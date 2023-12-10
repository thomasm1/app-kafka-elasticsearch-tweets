 
export const LOGIN = [
    {email:"thomas1.maestas@gmail.com",
password:"pass"}, 
{email:"walter.white@gmail.com",
password:"pass"}
]


/////////// USERS ////////////////////////////////////////////
export const USERS = [
   { "0":
    {
        id: "0",
        fName: "Tom",
        lName: "Milton",
        email: "thomas1.maestas@gmail.com",
        password:"pass",
        memberSince: "02-04-2020",
        groupType: "Admin",
        userId:"string",
        tokenId: "string", 
        addresses: [
            {
                id:0,
                description: "NFT - 0x1",
                owner: "thomas1.maestas@gmail.com",
                address: "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
                chain: "ethereum",
                blockExplorerUrl:"https://explorer-mainnet.maticvigil.com/address/0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
                ownerId: 0,
                chainId: 4
            },
            {
                id: 1,
                description: "NFT - 0x1",
                owner: "thomas1.maestas@gmail.com",
                address: "0x5f7B0DDd217D55bFC4927b3E49E3CbF57FA81834",
                chain: "ethereum",
                blockExplorerUrl:"https://explorer-mainnet.maticvigil.com/address/0x5f7B0DDd217D55bFC4927b3E49E3CbF57FA81834",
                ownerId: 0,
                chainId: 4
            },
            {
                id: 4,
                description: "NFT - 0x1",
                owner: "thomas1.maestas@gmail.com",
                address: "0x5f7B0DDd217D55bFC4927b3E49E3CbF57FA81834",
                chain: "polygon",
                blockExplorerUrl:"https://explorer-mainnet.maticvigil.com/address/0x5f7B0DDd217D55bFC4927b3E49E3CbF57FA81834",
                ownerId: 0,
                chainId: 137
            },
            {
                id: 5,
                description: "NFT - 0x1",
                owner: "thomas1.maestas@gmail.com",
                address: "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
                chain: "polygon",
                blockExplorerUrl:"https://explorer-mainnet.maticvigil.com/address/0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
                ownerId: 0,
                chainId: 137
            },
            {
                id: 6,
                description: "NFT - 0x1",
                owner: "thomas1.maestas@gmail.com",
                address: "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
                chain: "avalanche",
                blockExplorerUrl:"https://explorer-mainnet.maticvigil.com/address/0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
                ownerId: 0,
                chainId: 43114
            }
        ],
    }},
   {"1":
    {
        id:"1",
        fName: "Jil",
        lName: "G",
        email: "jil@gmail.com",
        password:"pass",
        memberSince: "02-04-2020",
        groupType: "Premium",
        userId:"string",
        tokenId: "string", 
        addresses: [
            {
                id: 1,
                description: "NFT - 0x1",
                owner: "jil@gmail.com",
                address: "0xcfCa3FEBAceA3AbB643bA90C670D7c4E6D74b633",
                chain: "ethereum",
                blockExplorerUrl:"https://explorer-mainnet.maticvigil.com/address/0xcfCa3FEBAceA3AbB643bA90C670D7c4E6D74b633",
                ownerId: 1,
                chainId: 1
            },
            {
                id: 4,
                description: "NFT - 0x1",
                owner: "jil@gmail.com",
                address: "0x5f7B0DDd217D55bFC4927b3E49E3CbF57FA81834",
                chain: "polygon",
                blockExplorerUrl:"https://explorer-mainnet.maticvigil.com/address/0x5f7B0DDd217D55bFC4927b3E49E3CbF57FA81834",
                ownerId: 1,
                chainId: 1
            },
        ],
    }},
    {"2":{
        id: "2",
        fName: "Walter",
        lName: "White",
        email: "walter.white@gmail.com",
        password:"pass",
        memberSince: "02-04-2020",
        groupType: "Premium",
        userId:"string",
        tokenId: "string", 
        addresses: [
            {
                id: 1,
                description: "NFT - 0x1",
                owner: "walter.white@gmail.com",
                address: "0xcfCa3FEBAceA3AbB643bA90C670D7c4E6D74b633",
                chain: "binance",
                blockExplorerUrl:"https://explorer-mainnet.maticvigil.com/address/0xcfCa3FEBAceA3AbB643bA90C670D7c4E6D74b633",
                ownerId: 2,
                chainId: 1
            },
            {
                id: 4,
                description: "NFT - 0x1",
                owner: "walter.white@gmail.com",
                address: "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
                chain: "binance",
                blockExplorerUrl:"https://explorer-mainnet.maticvigil.com/address/0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
                ownerId: 2,
                chainId: 1
            },
        ],
    }},
];

/////////// POSTS //////////////////////////////////////// //////////////////////////////////////
export const POSTS = {
    "1": {
        "id": "1",
        "title": "Hello World"
    },
    "2": {
        "id": "2",
        "title": "My2   post"
    },
    "3": {
        "id": "3",
        "title": "My   3 post"
    },
    "4": {
        "id": "4",
        "title": "4st"
    }
}

///////////  NFT_REFS //////////////////////////////////////// //////////////////////////////////////
export const NFT_REFS = {
    "-NKEMZxPfzYObXOMhGvJ": {
        "address": "0xc8d6A88EF3627C7B666117Da5F6d23Ac0B01b156",
        "chain": "avalanche-212",
        "email": "thomas1.maestas@gmail.com"
    },
    "-NKPd8VzgcGjQ3R2FcMD": {
        "address": "0xc8d6A88EF3627C7B666117Da5F6d23Ac0B01b156",
        "chain": "pulsechain23",
        "email": "thomas1.maestas@gmail.com"
    },
    "-NKPdCfqfdZwwRCho-jR": {
        "address": "0xc8d6A88EF3627C7B666117Da5F6d23Ac0B01b156",
        "chain": "pulsechain23",
        "email": "thomas1.maestas@gmail.com"
    },
    "-NKPdDPlAV2on5cNe0X-": {
        "address": "0xc8d6A88EF3627C7B666117Da5F6d23Ac0B01b156",
        "chain": "pulsechain23",
        "email": "thomas1.maestas@gmail.com"
    },
    "-NKPddvcSbmHPtN4j9fR": {
        "address": "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        "chain": "ropstein",
        "email": "thomas1.maestas@gmail.com"
    },
    "-NKPdnBQSaiAaFFBLtNd": {
        "address": "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        "chain": "rinkeby",
        "email": "thomas1.maestas@gmail.com"
    },
    "-NKPeBEBcT6n1q8jByro": {
        "address": "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        "chain": "rinkeby",
        "email": "thomas1.maestas@gmail.com"
    },
    "-NKPeD-QhB5J_Wwe9Obn": {
        "address": "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        "chain": "rinkeby",
        "email": "thomas1.maestas@gmail.com"
    },
    "-NKPesZxmixtS5WxSoW_": {
        "address": "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        "chain": "fuji",
        "email": "thomas1.maestas@gmail.com"
    },
    "-NKPf17952XsLIaFBCRK": {
        "address": "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        "chain": "fuji",
        "email": "thomas1.maestas@gmail.com"
    },
    "-NKPfBg73DGAppuhwvmo": {
        "address": "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        "chain": "arbitrum",
        "email": "thomas1.maestas@gmail.com"
    },
    "address": "0xc8d6A88EF3627C7B666117Da5F6d23Ac0B01b156",
    "chain": "mumbai",
    "email": "thomas1.maestas@gmail.com"
}
 