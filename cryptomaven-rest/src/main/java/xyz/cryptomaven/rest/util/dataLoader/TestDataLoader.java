//package xyz.cryptomaven.rest.dataLoader;
//
//import lombok.RequiredArgsConstructor;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ResourceUtils;
//import xyz.cryptomaven.rest.models.Address;
//import xyz.cryptomaven.rest.models.Chain;
//import xyz.cryptomaven.rest.models.User;
//import xyz.cryptomaven.rest.models.dto.ChainCSVRecord;
//import xyz.cryptomaven.rest.repositories.AddressesRepository;
//import xyz.cryptomaven.rest.repositories.ChainsRepository;
//import xyz.cryptomaven.rest.repositories.UsersRepository;
//import xyz.cryptomaven.rest.service.ChainCsvService;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.sql.Date;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.*;
//
//
///**
// *
// */
//@Component
//@Profile("test")
//@RequiredArgsConstructor
//public class TestDataLoader implements CommandLineRunner {
//
//  private static final Logger log = LoggerFactory.getLogger(TestDataLoader.class);
//  private final ChainsRepository chainRepository;
//  private final ChainCsvService chainCsvService;
//  private Set<Chain> chains = new HashSet<>();
//
//  private List<User> users = new ArrayList<>();
//
//  private List<Address> addresses = new ArrayList<>();
//
//
//  @Override
//  public void run(String... args) throws Exception {
//    loadCsvData();
//  }
//
//  private void loadCsvData() throws FileNotFoundException {
//    if (chainRepository.count() < 10) {
//      File file = ResourceUtils.getFile("classpath:data/chains.csv");
//
//      List<ChainCSVRecord> recs = chainCsvService.convertCSV(file);
//
//      recs.forEach(chainCSVRecord -> {
////                String symbol = switch (chainCSVRecord.getSymbol().toString()) {
////                    case "Ethereum" -> Symbol.ETH;
////                    case "Wrapped Bitcoin", "Bitcoin" ->
////                            Symbol.BTC;
////                    case "ChainLink", "Ethereum from Polygon", "Polygon" -> Symbol.MATIC;
////                    case "Pulsechain", "Hex from Pulsechain" -> Symbol.PLS;
////                    case "Solana Chain", "Solana" -> Symbol.SOL;
////                    case "Binance Chain" -> Symbol.BNB;
////                    case "avalanche", "Avalanche Mainnet", "Avalanche" -> Symbol.AVAX;
////                    case "XRP", "Ripple" -> Symbol.XRP;
////                    default -> Symbol.ETH;
////                };
//
//        chainRepository.save(Chain.builder()
//          .name(StringUtils.abbreviate(chainCSVRecord.getName(), 250))
//          .symbol(chainCSVRecord.getSymbol())
//          .iconUrl(chainCSVRecord.getIconUrl())
//          .description(chainCSVRecord.getDescription())
//          .longDescription(chainCSVRecord.getLongDescription())
////                                .category(chainCSVRecord.getCategory())
//          .chainListIcon(chainCSVRecord.getChainListIcon())
//          .rpcUrl(chainCSVRecord.getRpcUrl())
//          .id(chainCSVRecord.getId())
//          .blockExplorerUrl(chainCSVRecord.getBlockExplorerUrl())
////                                .dateCreated(new Date(2021,10,10))
////                                .lastUpdated(LocalDateTime.now())
//          .build());
//      });
//    }
//  }
//
//}
