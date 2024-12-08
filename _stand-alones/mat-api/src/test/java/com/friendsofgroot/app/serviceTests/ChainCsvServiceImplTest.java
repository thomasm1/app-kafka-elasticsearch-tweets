package com.friendsofgroot.app.serviceTests;

import com.friendsofgroot.app.models.dto.ChainCSVRecord;
import com.friendsofgroot.app.service.ChainCsvService;
import com.friendsofgroot.app.service.ChainCsvServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ChainCsvServiceImplTest {
    ChainCsvService chainCsvService = new ChainCsvServiceImpl();

    @Test
    void convertCSV() throws FileNotFoundException {

        File file = ResourceUtils.getFile("classpath:csvdata/chains.csv");

        List<ChainCSVRecord> recs = chainCsvService.convertCSV(file);

        System.out.println(recs.size());

        assertThat(recs.size()).isGreaterThan(0);
    }
}
