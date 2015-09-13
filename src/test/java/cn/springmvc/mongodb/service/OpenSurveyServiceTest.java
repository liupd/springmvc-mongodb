package cn.springmvc.mongodb.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.springmvc.mongo.common.utils.fmt.FormatFactory;
import cn.springmvc.mongo.entity.OpenSurvey;
import cn.springmvc.mongo.service.OpenSurveyService;

/**
 * @author Vincent.wang
 *
 *         production为生产环境，development为测试环境
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml", "classpath:/spring/applicationContext-dao.xml" })
@ActiveProfiles("development")
public class OpenSurveyServiceTest {

    private static final Logger log = LoggerFactory.getLogger(OpenSurveyServiceTest.class);

    @Autowired
    private OpenSurveyService openSurveyService;

    @Test
    public void findOpenSurveyAll() {
        try {
            List<OpenSurvey> surveys = openSurveyService.findOpenSurveyAll();
            if (CollectionUtils.isNotEmpty(surveys)) {
                for (OpenSurvey s : surveys) {
                    log.warn("## {}", FormatFactory.objectToJson(s));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
