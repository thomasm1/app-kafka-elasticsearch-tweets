package com.friendsofgroot.app.service;

import com.friendsofgroot.app.models.dto.ChainCSVRecord;

import java.io.File;
import java.util.List;

/**
*
 */
public interface ChainCsvService {
    List<ChainCSVRecord> convertCSV(File csvFile);
}
