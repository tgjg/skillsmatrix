package com.tg.skillsmatrix.service;

import com.tg.skillsmatrix.services.Importer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ImporterTest {

    @Autowired
    Importer importer;

    @Test
    void importTest() throws Exception {

        importer.import_core_skills();


    }
}
