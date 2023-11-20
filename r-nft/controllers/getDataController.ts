import Moralis  from "moralis" 

export async function getDataController(address, chain) {
    // GET NATIVE BAL
    const nativeBal = await Moralis.EvmApi.balance.getNativeBalance({
        address,
        chain
    })
    // Format native bal formated in ether via the .ether getter
    const native = nativeBal.result.balance.ether
    // GET TOKEN BAL
    const tokenBals = await Moralis.EvmApi.token.getWalletTokenBalances({
        address,
        chain
})
    // Format token bal formated to readable outpu with display() method
    const tokens = tokenBals.result.map((token) => token.display());
    // GET NFTs
    const nftBals = await Moralis.EvmApi.nft.getWalletNFTs({
        address,
        chain,
        limit:10,
    })
    // Format outpu to return name, amount and metadata
    const nfts = nftBals.result.map((nft) => ({
    name: nft.result.name,
    amount: nft.result.amount,
    metadata: nft.result.metadata,
    }))
    return { native, tokens, nfts }
}
 