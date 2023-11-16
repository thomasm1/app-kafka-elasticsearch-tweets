"use strict";
exports.__esModule = true;
exports.findAddressesForChain = exports.findChainById = exports.NFT_POLY = exports.NFT_ETH = exports.NFTS_POLYGON = exports.NFTS_ETHEREUM = exports.NFT_REFS = exports.USERS = exports.LOGIN = exports.ADDRESSES = exports.CHAINS = void 0;
exports.CHAINS = {
    1: {
        id: 1,
        name: "ethereum",
        symbol: "eth",
        description: "Ethereum Mainnet",
        longDescription: "NFT - 0x1",
        iconUrl: "https://s3.amazonaws.com/tmm.net/img/ether.png",
        category: "Mainnet",
        chainListIcon: "https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png",
        rpcUrl: "https://mainnet.infura.io/v3/9aa3d95b3bc440fa88ea12eaa4456161",
        addressesCount: 3
    },
    137: {
        id: 137,
        name: "polygon",
        symbol: "matic",
        description: "Polygon Mainnet",
        longDescription: "NFT - 0x1",
        iconUrl: "https://s3.amazonaws.com/tmm.net/img/polygon.jpg",
        category: "Mainnet",
        chainListIcon: "https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png",
        rpcUrl: " https://rpc-mainnet.maticvigil.com/",
        addressesCount: 3
    },
    56: {
        id: 56,
        symbol: "bnb",
        description: "BNB Mainnet",
        longDescription: "NFT - 0x1",
        iconUrl: "https://s3.amazonaws.com/tmm.net/img/bnb.png",
        category: "Mainnet",
        chainListIcon: "https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png",
        rpcUrl: " https://bsc-dataseed.binance.org/",
        addressesCount: 3
    },
    99: {
        id: 99,
        name: "solana",
        symbol: "sol",
        description: "solana Mainnet",
        longDescription: "NFT - 0x1",
        iconUrl: "https://s3.amazonaws.com/tmm.net/img/solana.jpg",
        category: "Mainnet",
        chainListIcon: "https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png",
        rpcUrl: "https://api.mainnet-beta.solana.com",
        addressesCount: 3
    },
    999: {
        id: 999,
        name: "pulsechain",
        symbol: "pls",
        description: "Pulsechain Mainnet",
        longDescription: "NFT - 0x1",
        iconUrl: "https://s3.amazonaws.com/tmm.net/img/pulsechain.png",
        category: "Mainnet",
        chainListIcon: "https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png",
        rpcUrl: "https://rpc.pulsechain.io",
        addressesCount: 3
    },
    43114: {
        id: 43114,
        name: "avalanche",
        symbol: "avax",
        description: "Avalanche C-Chain",
        longDescription: "NFT - 0x1",
        iconUrl: "https://s3.amazonaws.com/tmm.net/img/avax.png",
        category: "Mainnet",
        chainListIcon: "https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png",
        rpcUrl: "https://api.avax.network/ext/bc/C/rpc",
        addressesCount: 3
    }
};
exports.ADDRESSES = {
    0: {
        id: 0,
        description: "NFT - 0x1",
        owner: "thomasm1.maestas@gmail.com",
        address: "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        chain: "ethereum",
        blockExplorerUrl: "https://explorer-mainnet.maticvigil.com/address/0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        ownerId: 0,
        chainId: 1
    },
    1: {
        id: 1,
        description: "NFT - 0x1",
        owner: "thomasm1.maestas@gmail.com",
        address: "0x5f7B0DDd217D55bFC4927b3E49E3CbF57FA81834",
        chain: "ethereum",
        blockExplorerUrl: "https://explorer-mainnet.maticvigil.com/address/0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        ownerId: 0,
        chainId: 1
    },
    2: {
        id: 2,
        description: "NFT - 0x1",
        owner: "walter.white@gmail.com",
        address: "0xcfCa3FEBAceA3AbB643bA90C670D7c4E6D74b633",
        chain: "ethereum",
        blockExplorerUrl: "https://explorer-mainnet.maticvigil.com/address/0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        ownerId: 1,
        chainId: 1
    },
    3: {
        id: 3,
        description: "NFT - 0x1",
        owner: "walter.white@gmail.com",
        address: "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        chain: "ethereum",
        blockExplorerUrl: "https://explorer-mainnet.maticvigil.com/address/0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        ownerId: 1,
        chainId: 1
    },
    4: {
        id: 4,
        description: "NFT - 0x1",
        owner: "thomasm1.maestas@gmail.com",
        address: "0x5f7B0DDd217D55bFC4927b3E49E3CbF57FA81834",
        chain: "polygon",
        blockExplorerUrl: "https://explorer-mainnet.maticvigil.com/address/0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        ownerId: 0,
        chainId: 137
    },
    5: {
        id: 5,
        description: "NFT - 0x1",
        owner: "thomasm1.maestas@gmail.com",
        address: "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        chain: "polygon",
        blockExplorerUrl: "https://explorer-mainnet.maticvigil.com/address/0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        ownerId: 0,
        chainId: 137
    },
    6: {
        id: 6,
        description: "NFT - 0x1",
        owner: "thomasm1.maestas@gmail.com",
        address: "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        chain: "avalanche",
        blockExplorerUrl: "https://explorer-mainnet.maticvigil.com/address/0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        ownerId: 0,
        chainId: 43114
    }
};
exports.LOGIN = [
    { email: "thomasm1.maestas@gmail.com",
        password: "pass" },
    { email: "walter.white@gmail.com",
        password: "pass" }
];
/////////// USERS
exports.USERS = [
    {
        id: 0,
        fName: "Tom",
        lName: "Milton",
        email: "thomasm1.maestas@gmail.com",
        password: "pass",
        memberSince: "02-04-2020",
        groupType: "Admin",
        userId: "string",
        tokenId: "string",
        addresses: [
            {
                id: 0,
                description: "NFT - 0x1",
                owner: "thomasm1.maestas@gmail.com",
                address: "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
                chain: "ethereum",
                blockExplorerUrl: "https://explorer-mainnet.maticvigil.com/address/0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
                ownerId: 0,
                chainId: 4
            },
            {
                id: 1,
                description: "NFT - 0x1",
                owner: "thomasm1.maestas@gmail.com",
                address: "0x5f7B0DDd217D55bFC4927b3E49E3CbF57FA81834",
                chain: "ethereum",
                blockExplorerUrl: "https://explorer-mainnet.maticvigil.com/address/0x5f7B0DDd217D55bFC4927b3E49E3CbF57FA81834",
                ownerId: 0,
                chainId: 4
            },
            {
                id: 4,
                description: "NFT - 0x1",
                owner: "thomasm1.maestas@gmail.com",
                address: "0x5f7B0DDd217D55bFC4927b3E49E3CbF57FA81834",
                chain: "polygon",
                blockExplorerUrl: "https://explorer-mainnet.maticvigil.com/address/0x5f7B0DDd217D55bFC4927b3E49E3CbF57FA81834",
                ownerId: 0,
                chainId: 137
            },
            {
                id: 5,
                description: "NFT - 0x1",
                owner: "thomasm1.maestas@gmail.com",
                address: "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
                chain: "polygon",
                blockExplorerUrl: "https://explorer-mainnet.maticvigil.com/address/0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
                ownerId: 0,
                chainId: 137
            },
            {
                id: 6,
                description: "NFT - 0x1",
                owner: "thomasm1.maestas@gmail.com",
                address: "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
                chain: "avalanche",
                blockExplorerUrl: "https://explorer-mainnet.maticvigil.com/address/0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
                ownerId: 0,
                chainId: 43114
            }
        ]
    },
    {
        id: 1,
        fName: "Jil",
        lName: "G",
        email: "jil@gmail.com",
        password: "pass",
        memberSince: "02-04-2020",
        groupType: "Premium",
        userId: "string",
        tokenId: "string",
        addresses: [
            {
                id: 1,
                description: "NFT - 0x1",
                owner: "jil@gmail.com",
                address: "0xcfCa3FEBAceA3AbB643bA90C670D7c4E6D74b633",
                chain: "ethereum",
                blockExplorerUrl: "https://explorer-mainnet.maticvigil.com/address/0xcfCa3FEBAceA3AbB643bA90C670D7c4E6D74b633",
                ownerId: 1,
                chainId: 1
            },
            {
                id: 4,
                description: "NFT - 0x1",
                owner: "jil@gmail.com",
                address: "0x5f7B0DDd217D55bFC4927b3E49E3CbF57FA81834",
                chain: "polygon",
                blockExplorerUrl: "https://explorer-mainnet.maticvigil.com/address/0x5f7B0DDd217D55bFC4927b3E49E3CbF57FA81834",
                ownerId: 1,
                chainId: 1
            },
        ]
    },
    {
        id: 2,
        fName: "Walter",
        lName: "White",
        email: "walter.white@gmail.com",
        password: "pass",
        memberSince: "02-04-2020",
        groupType: "Premium",
        userId: "string",
        tokenId: "string",
        addresses: [
            {
                id: 1,
                description: "NFT - 0x1",
                owner: "walter.white@gmail.com",
                address: "0xcfCa3FEBAceA3AbB643bA90C670D7c4E6D74b633",
                chain: "binance",
                blockExplorerUrl: "https://explorer-mainnet.maticvigil.com/address/0xcfCa3FEBAceA3AbB643bA90C670D7c4E6D74b633",
                ownerId: 2,
                chainId: 1
            },
            {
                id: 4,
                description: "NFT - 0x1",
                owner: "walter.white@gmail.com",
                address: "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
                chain: "binance",
                blockExplorerUrl: "https://explorer-mainnet.maticvigil.com/address/0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
                ownerId: 2,
                chainId: 1
            },
        ]
    },
];
exports.NFT_REFS = {
    "-NKEMZxPfzYObXOMhGvJ": {
        "address": "0xc8d6A88EF3627C7B666117Da5F6d23Ac0B01b156",
        "chain": "avalanche-212",
        "email": "thomasm1.maestas@gmail.com"
    },
    "-NKPd8VzgcGjQ3R2FcMD": {
        "address": "0xc8d6A88EF3627C7B666117Da5F6d23Ac0B01b156",
        "chain": "pulsechain23",
        "email": "thomasm1.maestas@gmail.com"
    },
    "-NKPdCfqfdZwwRCho-jR": {
        "address": "0xc8d6A88EF3627C7B666117Da5F6d23Ac0B01b156",
        "chain": "pulsechain23",
        "email": "thomasm1.maestas@gmail.com"
    },
    "-NKPdDPlAV2on5cNe0X-": {
        "address": "0xc8d6A88EF3627C7B666117Da5F6d23Ac0B01b156",
        "chain": "pulsechain23",
        "email": "thomasm1.maestas@gmail.com"
    },
    "-NKPddvcSbmHPtN4j9fR": {
        "address": "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        "chain": "ropstein",
        "email": "thomasm1.maestas@gmail.com"
    },
    "-NKPdnBQSaiAaFFBLtNd": {
        "address": "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        "chain": "rinkeby",
        "email": "thomasm1.maestas@gmail.com"
    },
    "-NKPeBEBcT6n1q8jByro": {
        "address": "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        "chain": "rinkeby",
        "email": "thomasm1.maestas@gmail.com"
    },
    "-NKPeD-QhB5J_Wwe9Obn": {
        "address": "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        "chain": "rinkeby",
        "email": "thomasm1.maestas@gmail.com"
    },
    "-NKPesZxmixtS5WxSoW_": {
        "address": "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        "chain": "fuji",
        "email": "thomasm1.maestas@gmail.com"
    },
    "-NKPf17952XsLIaFBCRK": {
        "address": "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        "chain": "fuji",
        "email": "thomasm1.maestas@gmail.com"
    },
    "-NKPfBg73DGAppuhwvmo": {
        "address": "0x900bE021E38B8d08435A03c05657C8cFA837cAeF",
        "chain": "arbitrum",
        "email": "thomasm1.maestas@gmail.com"
    },
    "address": "0xc8d6A88EF3627C7B666117Da5F6d23Ac0B01b156",
    "chain": "mumbai",
    "email": "thomasm1.maestas@gmail.com"
};
exports.NFTS_ETHEREUM = [
    {
        "0x5f7B0DDd217D55bFC4927b3E49E3CbF57FA81834": {
            native: "0.0687",
            tokens: [
                "6.77777 USDC",
                "687.07777 HEX",
                "2.6977777 MATIC"
            ],
            nfts: [
                {
                    name: "One day,Ujuuna killed in explosion, and his reincarnation is decided at generative.",
                    amount: 1,
                    metadata: {
                        name: "Ten Uju Gene #08380",
                        description: "ある日、イケハヤさんと対談し、未来にワクワクしながら布団に入るうじゅうな……。  \n    \n  （明日からも頑張ろう……）  \n    \n  そう思った矢先、爆死し、転生してしまううじゅうな。  \n    \n  念願の転生は思っていたのとは、なんか違うようで……。  \n    \n  その転生先はあなたの目で見届けてほしい。",
                        image: "https://storage.googleapis.com/uju-explosion/images/8380.png",
                        attributes: [
                            {
                                value: "Tegaki",
                                trait_type: "Base"
                            },
                            {
                                value: "Tegaki",
                                trait_type: "Base"
                            }
                        ]
                    }
                }
            ]
        }
    },
    {
        "0xc8d6A88EF3627C7B666117Da5F6d23Ac0B01b156": {
            native: "0.02223232",
            tokens: [
                "2.0 USDC",
                "222.0232323 HEX",
                "2.022222 MATIC"
            ],
            nfts: [
                {
                    name: "One day,Ujuuna killed in explosion, and his reincarnation is decided at generative.",
                    amount: 1,
                    metadata: {
                        name: "Ten Uju Gene #08380",
                        description: "ある日、イケハヤさんと対談し、未来にワクワクしながら布団に入るうじゅうな……。  \n    \n  （明日からも頑張ろう……）  \n    \n  そう思った矢先、爆死し、転生してしまううじゅうな。  \n    \n  念願の転生は思っていたのとは、なんか違うようで……。  \n    \n  その転生先はあなたの目で見届けてほしい。",
                        image: "https://storage.googleapis.com/uju-explosion/images/8380.png",
                        attributes: [
                            {
                                value: "Tegaki",
                                trait_type: "Base"
                            },
                            {
                                value: "Tegaki",
                                trait_type: "Base"
                            }
                        ]
                    }
                }
            ]
        }
    },
    {
        "0x900bE021E38B8d08435A03c05657C8cFA837cAeF": {
            native: "0.03999",
            tokens: [
                "12.9999 USDC",
                "55.999990 HEX",
                "2.999999 MATIC"
            ],
            nfts: [
                {
                    name: "One day,Ujuuna killed in explosion, and his reincarnation is decided at generative.",
                    amount: 1,
                    metadata: {
                        name: "Ten Uju Gene #08380",
                        description: "ある日、イケハヤさんと対談し、未来にワクワクしながら布団に入るうじゅうな……。  \n    \n  （明日からも頑張ろう……）  \n    \n  そう思った矢先、爆死し、転生してしまううじゅうな。  \n    \n  念願の転生は思っていたのとは、なんか違うようで……。  \n    \n  その転生先はあなたの目で見届けてほしい。",
                        image: "https://storage.googleapis.com/uju-explosion/images/8380.png",
                        attributes: [
                            {
                                value: "Tegaki",
                                trait_type: "Base"
                            },
                            {
                                value: "Tegaki",
                                trait_type: "Base"
                            }
                        ]
                    }
                }
            ]
        }
    }
];
exports.NFTS_POLYGON = [
    {
        "0x5f7B0DDd217D55bFC4927b3E49E3CbF57FA81834": {
            "native": "0.0777",
            "tokens": [
                "540.0777 BalancerV2.com"
            ],
            "nfts": [
                {
                    "name": "apegril",
                    "amount": 1,
                    "metadata": {
                        "description": "Website: https://fashionfemaleape.club Users who have obtained Fashion Female APE Blind Box can log in to our official website to open the Blind Box to obtain NFT. Holders of Fashion Girl NFT can receive airdrop tokens. We randomly give random airdrops to lucky users who have interacted with opensea. Please don't worry, we are a legitimate project.",
                        "external_url": "https://fashionfemaleape.club",
                        "image": "ipfs://QmdEf1o8jhZP3NPwMLr5AHeXL17KD6VWoPdb6ojqQtgtTP",
                        "name": "Fashion Female APE Blinds",
                        "animation_url": "ipfs://QmcobaRC5cBqgMxuZkXVAV9iQjqZrVYSXfDxyn2V5Ba89r"
                    }
                },
                {
                    "name": "hwape",
                    "amount": 1,
                    "metadata": {
                        "description": "https://hwape.com We randomly airdrop ape card to lucky users who interact with opensea. Users who have obtained ape card can open the ape card through our official website hwape.com to obtain 3D ape NFTs. Please rest assured, we are a very interesting and legitimate project, and if you want to know about the development of our project, you can visit the official website to view the roadmap.",
                        "external_url": "https://hwape.com",
                        "image": "ipfs://QmVTf7Lyc6cm7nqTsUx4JWpUrMR6ryn4CoPgEFqxSsahB3",
                        "animation_url": "ipfs://QmU4RBf89Qnn83W5AUh3bTR4NR3ea4y2XktRk12iZzSNN8",
                        "name": "Hwape official Blind Card"
                    }
                }
            ]
        }
    },
    {
        "0xc8d6A88EF3627C7B666117Da5F6d23Ac0B01b156": {
            "native": "0.02323232323",
            "tokens": [
                "2323.0 BalancerV2.com"
            ],
            "nfts": [
                {
                    "name": "apegril",
                    "amount": 1,
                    "metadata": {
                        "description": "Website: https://fashionfemaleape.club Users who have obtained Fashion Female APE Blind Box can log in to our official website to open the Blind Box to obtain NFT. Holders of Fashion Girl NFT can receive airdrop tokens. We randomly give random airdrops to lucky users who have interacted with opensea. Please don't worry, we are a legitimate project.",
                        "external_url": "https://fashionfemaleape.club",
                        "image": "ipfs://QmdEf1o8jhZP3NPwMLr5AHeXL17KD6VWoPdb6ojqQtgtTP",
                        "name": "Fashion Female APE Blinds",
                        "animation_url": "ipfs://QmcobaRC5cBqgMxuZkXVAV9iQjqZrVYSXfDxyn2V5Ba89r"
                    }
                },
                {
                    "name": "hwape",
                    "amount": 1,
                    "metadata": {
                        "description": "https://hwape.com We randomly airdrop ape card to lucky users who interact with opensea. Users who have obtained ape card can open the ape card through our official website hwape.com to obtain 3D ape NFTs. Please rest assured, we are a very interesting and legitimate project, and if you want to know about the development of our project, you can visit the official website to view the roadmap.",
                        "external_url": "https://hwape.com",
                        "image": "ipfs://QmVTf7Lyc6cm7nqTsUx4JWpUrMR6ryn4CoPgEFqxSsahB3",
                        "animation_url": "ipfs://QmU4RBf89Qnn83W5AUh3bTR4NR3ea4y2XktRk12iZzSNN8",
                        "name": "Hwape official Blind Card"
                    }
                }
            ]
        }
    },
    {
        "0x900bE021E38B8d08435A03c05657C8cFA837cAeF": {
            "native": "0.99",
            "tokens": [
                "99999.0 BalancerV2.com"
            ],
            "nfts": [
                {
                    "name": "apegril",
                    "amount": 1,
                    "metadata": {
                        "description": "Website: https://fashionfemaleape.club Users who have obtained Fashion Female APE Blind Box can log in to our official website to open the Blind Box to obtain NFT. Holders of Fashion Girl NFT can receive airdrop tokens. We randomly give random airdrops to lucky users who have interacted with opensea. Please don't worry, we are a legitimate project.",
                        "external_url": "https://fashionfemaleape.club",
                        "image": "ipfs://QmdEf1o8jhZP3NPwMLr5AHeXL17KD6VWoPdb6ojqQtgtTP",
                        "name": "Fashion Female APE Blinds",
                        "animation_url": "ipfs://QmcobaRC5cBqgMxuZkXVAV9iQjqZrVYSXfDxyn2V5Ba89r"
                    }
                },
                {
                    "name": "hwape",
                    "amount": 1,
                    "metadata": {
                        "description": "https://hwape.com We randomly airdrop ape card to lucky users who interact with opensea. Users who have obtained ape card can open the ape card through our official website hwape.com to obtain 3D ape NFTs. Please rest assured, we are a very interesting and legitimate project, and if you want to know about the development of our project, you can visit the official website to view the roadmap.",
                        "external_url": "https://hwape.com",
                        "image": "ipfs://QmVTf7Lyc6cm7nqTsUx4JWpUrMR6ryn4CoPgEFqxSsahB3",
                        "animation_url": "ipfs://QmU4RBf89Qnn83W5AUh3bTR4NR3ea4y2XktRk12iZzSNN8",
                        "name": "Hwape official Blind Card"
                    }
                }
            ]
        }
    }
];
exports.NFT_ETH = {
    native: "0.03435",
    tokens: [
        "12.0 USDC",
        "55.0 HEX",
        "2.00265064 MATIC"
    ],
    nfts: [
        {
            name: "One day,Ujuuna killed in explosion, and his reincarnation is decided at generative.",
            amount: 1,
            metadata: {
                name: "Ten Uju Gene #08380",
                description: "ある日、イケハヤさんと対談し、未来にワクワクしながら布団に入るうじゅうな……。  \n    \n  （明日からも頑張ろう……）  \n    \n  そう思った矢先、爆死し、転生してしまううじゅうな。  \n    \n  念願の転生は思っていたのとは、なんか違うようで……。  \n    \n  その転生先はあなたの目で見届けてほしい。",
                image: "https://storage.googleapis.com/uju-explosion/images/8380.png",
                attributes: [
                    {
                        value: "Tegaki",
                        trait_type: "Base"
                    },
                    {
                        value: "Tegaki",
                        trait_type: "Base"
                    }
                ]
            }
        }
    ]
};
exports.NFT_POLY = {
    "native": "0.0",
    "tokens": [
        "540.0 BalancerV2.com"
    ],
    "nfts": [
        {
            "name": "apegril",
            "amount": 1,
            "metadata": {
                "description": "Website: https://fashionfemaleape.club Users who have obtained Fashion Female APE Blind Box can log in to our official website to open the Blind Box to obtain NFT. Holders of Fashion Girl NFT can receive airdrop tokens. We randomly give random airdrops to lucky users who have interacted with opensea. Please don't worry, we are a legitimate project.",
                "external_url": "https://fashionfemaleape.club",
                "image": "ipfs://QmdEf1o8jhZP3NPwMLr5AHeXL17KD6VWoPdb6ojqQtgtTP",
                "name": "Fashion Female APE Blinds",
                "animation_url": "ipfs://QmcobaRC5cBqgMxuZkXVAV9iQjqZrVYSXfDxyn2V5Ba89r"
            }
        },
        {
            "name": "hwape",
            "amount": 1,
            "metadata": {
                "description": "https://hwape.com We randomly airdrop ape card to lucky users who interact with opensea. Users who have obtained ape card can open the ape card through our official website hwape.com to obtain 3D ape NFTs. Please rest assured, we are a very interesting and legitimate project, and if you want to know about the development of our project, you can visit the official website to view the roadmap.",
                "external_url": "https://hwape.com",
                "image": "ipfs://QmVTf7Lyc6cm7nqTsUx4JWpUrMR6ryn4CoPgEFqxSsahB3",
                "animation_url": "ipfs://QmU4RBf89Qnn83W5AUh3bTR4NR3ea4y2XktRk12iZzSNN8",
                "name": "Hwape official Blind Card"
            }
        }
    ]
};
function findChainById(chainId) {
    return exports.CHAINS[chainId];
}
exports.findChainById = findChainById;
function findAddressesForChain(chainId) {
    return Object.values(exports.ADDRESSES).filter(function (address) { return address.chainId == chainId; });
}
exports.findAddressesForChain = findAddressesForChain;
