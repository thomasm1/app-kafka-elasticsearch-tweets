package xyz.cryptomaven.rest.services;

import xyz.cryptomaven.rest.models.dto.ChainCSVRecord;

import java.io.File;
import java.util.List;

/**
*
 */
public interface ChainCsvService {
    List<ChainCSVRecord> convertCSV(File csvFile);
}
