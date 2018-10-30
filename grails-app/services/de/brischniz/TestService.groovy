package de.brischniz

import grails.gorm.services.Service
import org.hibernate.SessionFactory

interface ITestService {
    Test get(Serializable id)
    List<Test> list(Map args)
    Long count()
    void delete(Serializable id)
    Test save(Test test)
}

@Service(Test)
abstract class TestService implements ITestService {

    // SessionFactory sessionFactory

    List saveTests(List<Test> tests) {

		if (tests) {

			tests.each { Test test ->
                test.save()
            }
            // sessionFactory.getCurrentSession().flush()

            Integer testCount = Test.count()

            log.info("Import of ${testCount} stations finished")
            return tests
		}
	}
}

