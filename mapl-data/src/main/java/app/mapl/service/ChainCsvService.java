package app.mapl.service;

import app.mapl.models.dto.ChainCSVRecord;

import java.io.File;
import java.util.List;

/**
*
 */
public interface ChainCsvService {
    List<ChainCSVRecord> convertCSV(File csvFile);
}
