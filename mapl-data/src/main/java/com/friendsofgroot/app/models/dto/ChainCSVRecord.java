package com.friendsofgroot.app.models.dto;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
*
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChainCSVRecord {

//    @CsvBindByName
//    private Integer row;

    @CsvBindByName(column = "chain_id")
    private Integer chainId;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private  String symbol;

    @CsvBindByName
    private String description;

    @CsvBindByName
    private String longDescription;

    @CsvBindByName
    private String iconUrl;

    @CsvBindByName(column = "chain_list_icon")
    private String chainListIcon;

    @CsvBindByName(column = "rpc_url")
    private String rpcUrl;

    @CsvBindByName
    private Integer id;

    @CsvBindByName(column = "block_explorer_url")
    private String blockExplorerUrl;


    @CsvBindByName
    private Float price;
//
//    @CsvBindByName(column = "count.y")
//    private String count_y;

//    @CsvBindByName
//    private String label;

}
