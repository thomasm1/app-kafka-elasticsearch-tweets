package xyz.climongoapp.methods.http;


import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.hibernate.validator.internal.util.privilegedactions.GetAnnotationAttribute;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Web3NFT {
    public static void main(String[] args) throws IOException {

        PrintNFTsByWallet();
    }
    static void PrintNFTsByWallet() throws IOException {
        AsyncHttpClient client = new DefaultAsyncHttpClient();
        String addr =  System.getenv("DEFAULT_ADDRESS");

        String key =  System.getenv("MORALIS_API_KEY");
        String path = "https://deep-index.moralis.io/api/v2/"+ addr+"/nft?chain=eth&format=decimal&normalizeMetadata=false";

        client.prepare("GET", path)
                .setHeader("accept", "application/json")
                .setHeader("X-API-Key", key)
                .execute()
                .toCompletableFuture()
                .thenAccept(System.out::println)
                .join();

        client.close();
    }
}
//{
//        "total": 2,
//        "page": 1,
//        "page_size": 100,
//        "cursor": null,
//        "result": [
//        {
//        "token_address": "0x6d6f738e4695b56c9f3cb942b493a290ee29c178",
//        "token_id": "8380",
//        "owner_of": "0x900be021e38b8d08435a03c05657c8cfa837caef",
//        "block_number": "15948832",
//        "block_number_minted": "15946715",
//        "token_hash": "d83dbf2940ffb6c208016475bc4d569a",
//        "amount": "1",
//        "contract_type": "ERC721",
//        "name": "One day,Ujuuna killed in explosion, and his reincarnation is decided at generative.",
//        "symbol": "UJU",
//        "token_uri": "https://storage.googleapis.com/uju-explosion/json/8380.json",
//        "metadata": "{\"name\":\"Ten Uju Gene #08380\",\"description\":\"ある日、イケハヤさんと対談し、未来にワクワクしながら布団に入るうじゅうな……。  \\n    \\n  （明日からも頑張ろう……）  \\n    \\n  そう思った矢先、爆死し、転生してしまううじゅうな。  \\n    \\n  念願の転生は思っていたのとは、なんか違うようで……。  \\n    \\n  その転生先はあなたの目で見届けてほしい。\",\"image\":\"https://storage.googleapis.com/uju-explosion/images/8380.png\",\"attributes\":[{\"value\":\"Tegaki\",\"trait_type\":\"Base\"},{\"value\":\"Knight\",\"trait_type\":\"1st panel\"},{\"trait_type\":\"1st panel option\",\"value\":\"None\"},{\"trait_type\":\"2nd panel\",\"value\":\"Boss\"},{\"value\":\"None\",\"trait_type\":\"2nd panel option\"},{\"trait_type\":\"3rd panel\",\"value\":\"Fall\"},{\"value\":\"Nobuyuki\",\"trait_type\":\"3rd panel option\"},{\"trait_type\":\"4th panel\",\"value\":\"Reincarnation\"},{\"trait_type\":\"4th panel option\",\"value\":\"Sailor suit uncle\"},{\"value\":\"Massage8\",\"trait_type\":\"Massage\"}]}",
//        "last_token_uri_sync": "2022-11-11T12:16:29.577Z",
//        "last_metadata_sync": "2022-11-11T12:16:41.761Z",
//        "minter_address": "0x809d2077d085f20c8e18159afbfbf58367b2544d"
//        },
//        {
//        "token_address": "0x6d6f738e4695b56c9f3cb942b493a290ee29c178",
//        "token_id": "8260",
//        "owner_of": "0x900be021e38b8d08435a03c05657c8cfa837caef",
//        "block_number": "15948823",
//        "block_number_minted": "15946406",
//        "token_hash": "935b001cbc4485550d51cf6e76d85e5f",
//        "amount": "1",
//        "contract_type": "ERC721",
//        "name": "One day,Ujuuna killed in explosion, and his reincarnation is decided at generative.",
//        "symbol": "UJU",
//        "token_uri": "https://storage.googleapis.com/uju-explosion/json/8260.json",
//        "metadata": "{\"name\":\"Ten Uju Gene #08260\",\"description\":\"ある日、イケハヤさんと対談し、未来にワクワクしながら布団に入るうじゅうな……。  \\n    \\n  （明日からも頑張ろう……）  \\n    \\n  そう思った矢先、爆死し、転生してしまううじゅうな。  \\n    \\n  念願の転生は思っていたのとは、なんか違うようで……。  \\n    \\n  その転生先はあなたの目で見届けてほしい。\",\"image\":\"https://storage.googleapis.com/uju-explosion/images/8260.png\",\"attributes\":[{\"trait_type\":\"Base\",\"value\":\"Tegaki silver\"},{\"trait_type\":\"1st panel\",\"value\":\"Knight\"},{\"value\":\"None\",\"trait_type\":\"1st panel option\"},{\"value\":\"UFO\",\"trait_type\":\"2nd panel\"},{\"trait_type\":\"2nd panel option\",\"value\":\"Kiyoshi\"},{\"trait_type\":\"3rd panel\",\"value\":\"Sentaku\"},{\"value\":\"None\",\"trait_type\":\"3rd panel option\"},{\"trait_type\":\"4th panel\",\"value\":\"God\"},{\"trait_type\":\"4th panel option\",\"value\":\"Uju2\"},{\"trait_type\":\"Massage\",\"value\":\"Massage13\"}]}",
//        "last_token_uri_sync": "2022-11-11T11:13:45.677Z",
//        "last_metadata_sync": "2022-11-11T11:13:51.633Z",
//        "minter_address": "0xadd62287c10d90f65fd3bf8bf94183df115c030a"
//        }
//        ],
//        "status": "SYNCED"
//        }