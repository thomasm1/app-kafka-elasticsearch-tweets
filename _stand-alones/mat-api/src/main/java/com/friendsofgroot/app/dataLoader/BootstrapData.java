package com.friendsofgroot.app.dataLoader;

import com.friendsofgroot.app.models.Chain;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.models.dto.ChainCSVRecord;
import com.friendsofgroot.app.models.dto.Symbol;
import com.friendsofgroot.app.repositories.ChainsRepository;
import com.friendsofgroot.app.repositories.UsersRepository;
import com.friendsofgroot.app.service.ChainCsvService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


/**
*
 */
@Component
@Profile("!prod")
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(BootstrapData.class);
    private final ChainsRepository chainRepository;
    private final UsersRepository userRepository;
    private final ChainCsvService chainCsvService;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        loadChainData();
        loadCsvData();
        loadUserData();
    }

    private void loadCsvData() throws FileNotFoundException {
        if (chainRepository.count() < 10){
            File file = ResourceUtils.getFile("classpath:data/chains.csv");

            List<ChainCSVRecord> recs = chainCsvService.convertCSV(file);

            recs.forEach(chainCSVRecord -> {
//                String symbol = switch (chainCSVRecord.getSymbol().toString()) {
//                    case "Ethereum" -> Symbol.ETH;
//                    case "Wrapped Bitcoin", "Bitcoin" ->
//                            Symbol.BTC;
//                    case "ChainLink", "Ethereum from Polygon", "Polygon" -> Symbol.MATIC;
//                    case "Pulsechain", "Hex from Pulsechain" -> Symbol.PLS;
//                    case "Solana Chain", "Solana" -> Symbol.SOL;
//                    case "Binance Chain" -> Symbol.BNB;
//                    case "avalanche", "Avalanche Mainnet", "Avalanche" -> Symbol.AVAX;
//                    case "XRP", "Ripple" -> Symbol.XRP;
//                    default -> Symbol.ETH;
//                };

                chainRepository.save(Chain.builder()
                                .name(StringUtils.abbreviate(chainCSVRecord.getName(), 250))
                                .symbol(chainCSVRecord.getSymbol())
                                .iconUrl(chainCSVRecord.getIconUrl())
                                .description(chainCSVRecord.getDescription())
                                .longDescription(chainCSVRecord.getLongDescription())
//                                .category(chainCSVRecord.getCategory())
                                .chainListIcon(chainCSVRecord.getChainListIcon())
                                .rpcUrl(chainCSVRecord.getRpcUrl())
                                .id(chainCSVRecord.getId())
                                .blockExplorerUrl(chainCSVRecord.getBlockExplorerUrl())
//                                .dateCreated(new Date(2021,10,10))
//                                .lastUpdated(LocalDateTime.now())
                        .build());
            });
        }
    }

    private void loadChainData() {
        if (chainRepository.count() == 0){
            Chain  chain1 = Chain.builder()
                    .name("Galaxy Cat")
                    .symbol("PLS")
//                    .dateCreated(Date.valueOf(LocalDate.now()))
//                    .createdDate( (LocalDateTime.now()))
//                    .lastUpdated(LocalDateTime.now())
//                    .updatedAt(Timestamp.valueOf(LocalDateTime.now()))
                    .build();

            Chain chain2 = Chain.builder()
                    .name("Crank")
                    .symbol("ETH")
//                    .dateCreated(Date.valueOf(LocalDate.now()))
//                    .createdDate( (LocalDateTime.now()))
//                    .lastUpdated(LocalDateTime.now())
//                    .updatedAt(Timestamp.valueOf(LocalDateTime.now()))
                    .build();

            Chain chain3 = Chain.builder()
                    .name("Sunshine City")
                    .symbol("SOL")
                    .id(12356)
//                    .dateCreated(Date.valueOf(LocalDate.now()))
//                    .createdDate(LocalDateTime.now())
//                    .lastUpdated(LocalDateTime.now())
//                    .updatedAt(Timestamp.valueOf(LocalDateTime.now()))
                    .build();

            chainRepository.save(chain1);
            chainRepository.save(chain2);
            chainRepository.save(chain3);
        }

    }

    private void loadUserData() {

        if (userRepository.count() == 0) {
            User user1 = User.builder()
                    .userId((int) Math.floor(Math.random()))
                    .username("User 3")
//                    .createdDate(LocalDateTime.now())
//                    .updateDate(LocalDateTime.now())
                    .build();

            User user2 = User.builder()
                    .userId((int) Math.floor(Math.random()))
                    .username("User 3")
//                    .createdDate(LocalDateTime.now())
//                    .updateDate(LocalDateTime.now())
                    .build();

            User user3 = User.builder()
                    .userId((int) Math.floor(Math.random()))
                    .username("User 3")
//                    .createdDate(LocalDateTime.now())
//                    .updateDate(LocalDateTime.now())
                    .build();

            userRepository.saveAll(Arrays.asList(user1, user2, user3));
        }

    }
}
