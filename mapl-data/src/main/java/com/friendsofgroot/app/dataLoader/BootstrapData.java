package com.friendsofgroot.app.dataLoader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.friendsofgroot.app.models.Chain;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.models.dto.ChainCSVRecord;
import com.friendsofgroot.app.models.dto.ChainDto;
import com.friendsofgroot.app.models.dto.Symbol;
import com.friendsofgroot.app.models.dto.UserDto;
import com.friendsofgroot.app.repositories.ChainsRepository;
import com.friendsofgroot.app.repositories.UsersRepository;
import com.friendsofgroot.app.service.ChainCsvService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static com.friendsofgroot.app.util.constants.Constants.FILE_IN_USERS;
import static com.friendsofgroot.app.util.constants.Constants.FILE_OUT_WEBLINKS;


/**
 *
 */
@Component
@Profile("local")
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(BootstrapData.class);
    private static final String FILE_OUT_USERS = "data/default-output.txt" ;
    private final ChainsRepository chainRepository;
    private final UsersRepository userRepository;
    private final ChainCsvService chainCsvService;
    List<ChainCSVRecord> recs;
    CSVFormat chainCsvFormat;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        loadChainData();
        loadCsvData();
        loadUserData();
    }

    private void loadCsvData() throws FileNotFoundException {
        if (chainRepository.count() < 10) {
            File file = ResourceUtils.getFile("classpath:data/chains.csv");

             recs = chainCsvService.convertCSV(file);
            recs.forEach(chainCSVRecord -> {

                chainCSVRecord.setChainId((int) Math.floor(Math.random()));

//            recs.forEach(chainCSVRecord -> {
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
                        .chainId((int) Math.floor(Math.random()))
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
    private void finalizeCsvData() throws IOException {


        chainCsvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(new String[] {"chainName", "chainId"})
                .build();

        CSVPrinter finalCsv = new CSVPrinter(new FileWriter("data/chains-saved-"+ System.currentTimeMillis()+".csv"),chainCsvFormat);
        ObjectMapper mapper = new ObjectMapper();
        String token = "xyz";
        // get verified chain data from web3
        String chains = getRequest("http://localhost:8080/api/chains/", token);
//        String users = getRequest("http://localhost:8080/api/users/", token);
        Map<String,Object> chainsDataMap = (Map<String, Object>) mapper.readValue(chains, Chain.class);
        List<ChainDto> chainsList = new ArrayList();
        Map<String, ChainDto> chainsMap = new HashMap<>();
        for (Map<String, String> chainDto : (List<Map<String, String>>) chainsDataMap.get("data")) {
            ChainDto chain = mapper.convertValue(chainDto, ChainDto.class);
            chainsList.add(chain);
            chainsMap.put(String.valueOf(chain.getChainId()), chain);
        }
        for(ChainDto chainDto : chainsList) {
            finalCsv.printRecord(chainDto.getChainId(), chainDto.getName());
            if (chainDto.getSymbol().isEmpty()) {
                break;
            } else {
               System.out.println("valid chain symbol");
            }
        }


    }

    public static String readFromFilename(List<String> data, String filename) throws FileNotFoundException, UnsupportedEncodingException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"UTF-8"))) {
            String line;
            System.out.println("filename "+filename);
            while ((line = br.readLine()) != null) {
                data.add(line);
                text.append(line).append("\n");
            }
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return text.toString();
    }


    public static String readFromStream(InputStream inStream) {
        StringBuilder text = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inStream))) {
            String line;
            while ((line = br.readLine()) !=null) {
                text.append(line).append("\n");
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text.toString();
    }

    public static void writeUser(User user) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        try {
            Writer output = null;
            File file = new File(FILE_OUT_USERS );
            output = new BufferedWriter(new FileWriter(file));
            output.write(user.toString());
            System.out.println("WRITTEN: "+user);
            output.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("Could not create file");
        }
    }

    // Most common way to read byte streams from a file
    public static void fileCopyWithBufferAndArray() {
        System.out.println("\nInside fileCopyWithBufferAndArray ...");

        long startTime, elapsedTime; // for speed benchmarking
        startTime = System.nanoTime();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(FILE_IN_USERS));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(FILE_OUT_USERS))) {

            byte[] byteBuf = new byte[4000];
            int numBytesRead;
            while ((numBytesRead = in.read(byteBuf)) != -1) {
                out.write(byteBuf, 0, numBytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("fileCopyWithBufferAndArray: " + (elapsedTime / 1000000.0) + " msec");
    }

    public static void writeUsers(List<User> users) {
        try {
            Writer output = null;
            File file = new File(FILE_OUT_USERS);
            output = new BufferedWriter(new FileWriter(file));
            for(int i = 0;i < users.size();i++) {
                output.write(users.get(i).toString());
                output.write("\n");
            }
            output.close();
            System.out.println("File has been written");
        } catch (FileNotFoundException e) {
            System.out.println("Could not create file");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Could not create file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Dynamically name webpage based on ID /// HARD-CODED LOCATION!
    public static boolean writeWebpage(String webpage, long id) {
        try(BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_OUT_WEBLINKS+String.valueOf(id)+".html"), "UTF-8"))) {
            wr.write(webpage);
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void urlHeaders(String in_url ) {
        try {
            URL url= new URL(in_url);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));

            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
            for(Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                System.out.println("key: "+key+"========= ");
                for(String v: value) {
                    System.out.println("Values: " +value);
                }
            }

        } catch(MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
    public String getRequest(String url, String token) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", StringUtils.join("Bearer ",token));
        HttpEntity entity = new HttpEntity(headers);
        response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    private void loadChainData() {
        if (chainRepository.count() == 0) {
            Chain chain1 = Chain.builder()
                    .chainId((int) Math.floor(Math.random()))
                    .name("Galaxy Cat")
                    .symbol("PLS")
                    .id(123)
//                    .dateCreated(Date.valueOf(LocalDate.now()))
//                    .createdDate( (LocalDateTime.now()))
//                    .lastUpdated(LocalDateTime.now())
//                    .updatedAt(Timestamp.valueOf(LocalDateTime.now()))
                    .build();

            Chain chain2 = Chain.builder()
                    .chainId((int) Math.floor(Math.random()))
                    .name("Crank")
                    .symbol("ETH")
                    .id(1236)
//                    .dateCreated(Date.valueOf(LocalDate.now()))
//                    .createdDate( (LocalDateTime.now()))
//                    .lastUpdated(LocalDateTime.now())
//                    .updatedAt(Timestamp.valueOf(LocalDateTime.now()))
                    .build();

            Chain chain3 = Chain.builder()
                    .chainId((int) Math.floor(Math.random()))
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

    private void loadUserData() throws IOException {

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
