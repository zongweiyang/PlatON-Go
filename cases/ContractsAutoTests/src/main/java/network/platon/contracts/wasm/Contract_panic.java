package network.platon.contracts.wasm;

import com.platon.rlp.datatypes.Uint64;
import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.WasmFunctionEncoder;
import org.web3j.abi.datatypes.WasmFunction;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.WasmContract;
import org.web3j.tx.gas.GasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the org.web3j.codegen.WasmFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with platon-web3j version 0.9.1.2-SNAPSHOT.
 */
public class Contract_panic extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001570f60027f7f0060017f0060017f017f60000060037f7f7f0060027f7f017f60037f7f7f017f60047f7f7f7f0060027f7e0060017f017e60077f7f7f7f7f7f7f0060037f7e7f006000017f60047f7f7f7f017f60017e017f02a9010703656e760c706c61746f6e5f70616e6963000303656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000c03656e7610706c61746f6e5f6765745f696e707574000103656e760d706c61746f6e5f72657475726e000003656e7617706c61746f6e5f6765745f73746174655f6c656e677468000503656e7610706c61746f6e5f6765745f7374617465000d03656e7610706c61746f6e5f7365745f737461746500070346450306050302020603030504040100040a0102030101060202020207000402010204000002000000000400080e0b0100000306090902010001020200000101000001080105000405017001050505030100020615037f0141908b040b7f0041908b040b7f00418a0b0b075406066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300070b5f5f686561705f6261736503010a5f5f646174615f656e6403020f5f5f66756e63735f6f6e5f65786974001906696e766f6b650037090a010041010b041b3536340a9347451800100a41a40a10181a4101101a41b00a10181a4104101a0ba20a010d7f2002410f6a210f410020026b21072002410e6a210a410120026b210e2002410d6a210d410220026b210c0340200020056a2103200120056a220441037145200220054672450440200320042d00003a0000200f417f6a210f200741016a2107200a417f6a210a200e41016a210e200d417f6a210d200c41016a210c200541016a21050c010b0b200220056b210602400240024002402003410371220b044020064120490d03200b4101460d01200b4102460d02200b4103470d032003200120056a280200220a3a0000200041016a210b200220056b417f6a210c200521030340200c4113494504402003200b6a2208200120036a220941046a2802002206411874200a41087672360200200841046a200941086a2802002204411874200641087672360200200841086a2009410c6a28020022064118742004410876723602002008410c6a200941106a280200220a411874200641087672360200200341106a2103200c41706a210c0c010b0b2002417f6a2007416d2007416d4b1b200f6a4170716b20056b2106200120036a41016a2104200020036a41016a21030c030b2006210403402004411049450440200020056a2203200120056a2202290200370200200341086a200241086a290200370200200541106a2105200441706a21040c010b0b027f2006410871450440200120056a2104200020056a0c010b200020056a2202200120056a2201290200370200200141086a2104200241086a0b21052006410471044020052004280200360200200441046a2104200541046a21050b20064102710440200520042f00003b0000200441026a2104200541026a21050b2006410171450d03200520042d00003a000020000f0b2003200120056a2206280200220a3a0000200341016a200641016a2f00003b0000200041036a210b200220056b417d6a210720052103034020074111494504402003200b6a2208200120036a220941046a2802002206410874200a41187672360200200841046a200941086a2802002204410874200641187672360200200841086a2009410c6a28020022064108742004411876723602002008410c6a200941106a280200220a410874200641187672360200200341106a2103200741706a21070c010b0b2002417d6a200c416f200c416f4b1b200d6a4170716b20056b2106200120036a41036a2104200020036a41036a21030c010b2003200120056a2206280200220d3a0000200341016a200641016a2d00003a0000200041026a210b200220056b417e6a210720052103034020074112494504402003200b6a2208200120036a220941046a2802002206411074200d41107672360200200841046a200941086a2802002204411074200641107672360200200841086a2009410c6a28020022064110742004411076723602002008410c6a200941106a280200220d411074200641107672360200200341106a2103200741706a21070c010b0b2002417e6a200e416e200e416e4b1b200a6a4170716b20056b2106200120036a41026a2104200020036a41026a21030b20064110710440200320042d00003a00002003200428000136000120032004290005370005200320042f000d3b000d200320042d000f3a000f200441106a2104200341106a21030b2006410871044020032004290000370000200441086a2104200341086a21030b2006410471044020032004280000360000200441046a2104200341046a21030b20064102710440200320042f00003b0000200441026a2104200341026a21030b2006410171450d00200320042d00003a00000b20000be10201027f02402001450d00200041003a0000200020016a2202417f6a41003a000020014103490d00200041003a0002200041003a00012002417d6a41003a00002002417e6a41003a000020014107490d00200041003a00032002417c6a41003a000020014109490d002000410020006b41037122036a220241003602002002200120036b417c7122036a2201417c6a410036020020034109490d002002410036020820024100360204200141786a4100360200200141746a410036020020034119490d002002410036021820024100360214200241003602102002410036020c200141706a41003602002001416c6a4100360200200141686a4100360200200141646a41003602002003200241047141187222036b2101200220036a2102034020014120490d0120024200370300200241186a4200370300200241106a4200370300200241086a4200370300200241206a2102200141606a21010c000b000b20000b3501017f230041106b220041908b0436020c418408200028020c41076a41787122003602004180082000360200418c083f003602000b9f0101047f230041106b220224002002200036020c027f02400240024020000440418c08200041086a22014110762200418c082802006a2203360200418408200141840828020022016a41076a4178712204360200200341107420044d0d0120000d020c030b41000c030b418c08200341016a360200200041016a21000b200040000d0010000b20012002410c6a410410081a200141086a0b200241106a24000b2f01027f2000410120001b2100034002402000100b22010d004190082802002202450d0020021103000c010b0b20010bc10301067f024020002001460d00027f02400240200120006b20026b410020024101746b4b044020002001734103712103200020014f0d012003450d0220000c030b20002001200210080f0b024020030d002001417f6a21030340200020026a220441037104402002450d052004417f6a200220036a2d00003a00002002417f6a21020c010b0b2000417c6a21032001417c6a2104034020024104490d01200220036a200220046a2802003602002002417c6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200241046a21062002417f73210503400240200120046a2107200020046a2208410371450d0020022004460d03200820072d00003a00002006417f6a2106200541016a2105200441016a21040c010b0b200220046b21014100210303402001410449450440200320086a200320076a280200360200200341046a21032001417c6a21010c010b0b200320076a210120022005417c2005417c4b1b20066a417c716b20046b2102200320086a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b20000b0a0041940841013602000b0a0041940841003602000b4d01017f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a28020036020020000f0b200020012802082001280204101120000b6401027f2002417049044002402002410a4d0440200020024101743a0000200041016a21030c010b200241106a4170712204100c21032000200236020420002004410172360200200020033602080b2003200120021012200220036a41003a00000f0b000b13002002047f20002001200210080520000b1a0b130020002d0000410171044020002802081a0b0b3401017f2000200147044020002001280208200141016a20012d0000220041017122021b2001280204200041017620021b10150b0bab0101037f410a2103027f0240027f024020002d00002205410171220404402000280200417e71417f6a21030b2003200249044020040d0120054101760c020b20040d02200041016a0c030b20002802040b210420002003200220036b200420042002200110160f0b20002802080b220421032002047f200320012002100d0520030b1a200220046a41003a000020002d0000410171450440200020024101743a00000f0b200020023602040bb70101027f416e20016b20024f0440027f200041016a20002d0000410171450d001a20002802080b2108027f416f200141e6ffffff074b0d001a410b20014101742207200120026a220220022007491b2202410b490d001a200241106a4170710b2207100c21022005044020022006200510120b200320046b220322060440200220056a200420086a200610120b200020023602082000200320056a220136020420002007410172360200200120026a41003a00000f0b000b2301017f03402001410c46450440200020016a4100360200200141046a21010c010b0b0b190020004200370200200041086a41003602002000101720000b7601037f100e41980828020021000340200004400340419c08419c082802002201417f6a22023602002001410148450440200020024102746a22004184016a280200200041046a280200100f110100100e41980828020021000c010b0b419c084120360200419808200028020022003602000c010b0b0b940101027f100e419808280200220145044041980841a00836020041a00821010b0240419c0828020022024120460440418402100b22010440200141840210091a0b2001450d0120014198082802003602004198082001360200419c084100360200410021020b419c08200241016a360200200120024102746a22014184016a4100360200200141046a2000360200100f0f0b100f0b070041a40a10130b780020004200370210200042ffffffff0f3702082000200129020037020002402002410871450d002000101d20012802044f0d002002410471450440200042003702000c010b10000b024002402002411071450d002000101d20012802044d0d0020024104710d01200042003702000b20000f0b100020000b290002402000280204044020002802002c0000417f4c0d0141010f0b41000f0b2000101e2000101f6a0b240002402000280204450d0020002802002c0000417f4c0d0041000f0b2000102441016a0b8a0301047f0240024020002802040440200010254101210220002802002c00002201417f4c0d010c020b41000f0b200141ff0171220241b7014d0440200241807f6a0f0b02400240200141ff0171220141bf014d04400240200041046a22042802002201200241c97e6a22034d047f100020042802000520010b4102490d0020002802002d00010d0010000b200341054f044010000b20002802002d000145044010000b410021024100210103402001200346450440200028020020016a41016a2d00002002410874722102200141016a21010c010b0b200241384f0d010c020b200141f7014d0440200241c07e6a0f0b0240200041046a22042802002201200241897e6a22034d047f100020042802000520010b4102490d0020002802002d00010d0010000b200341054f044010000b20002802002d000145044010000b410021024100210103402001200346450440200028020020016a41016a2d00002002410874722102200141016a21010c010b0b20024138490d010b200241ff7d490d010b100020020f0b20020b3902017f017e230041306b2201240020012000290200220237031020012002370308200141186a200141086a4114101c101d200141306a24000b5e01027f2000027f027f2001280200220504404100200220036a200128020422014b2001200249720d011a410020012003490d021a200220056a2104200120026b20032003417f461b0c020b41000b210441000b360204200020043602000b2101017f2001101f220220012802044b044010000b200020012001101e200210210b900302097f017e230041406a220324002001280208220520024b0440200341386a20011022200320032903383703182001200341186a102036020c200341306a20011022410021052001027f410020032802302206450d001a410020032802342208200128020c2207490d001a200820072007417f461b210420060b360210200141146a2004360200200141086a41003602000b200141106a2109200141146a21072001410c6a2106200141086a210803400240200520024f0d002007280200450d00200341306a2001102241002105027f2003280230220a044041002003280234220b20062802002204490d011a200b20046b21052004200a6a0c010b41000b210420072005360200200920043602002003200536022c2003200436022820032003290328370310200341306a20094100200341106a1020102120092003290330220c37020020062006280200200c422088a76a3602002008200828020041016a22053602000c010b0b20032009290200220c3703202003200c3703082000200341086a4114101c1a200341406b24000b4101017f02402000280204450d0020002802002d0000220041bf014d0440200041b801490d01200041c97e6a0f0b200041f801490d00200041897e6a21010b20010b4401017f200028020445044010000b0240200028020022012d0000418101470d00200041046a28020041014d047f100020002802000520010b2c00014100480d0010000b0b9f0101037f02402000280204044020001025200028020022022c000022014100480d0120014100470f0b41000f0b027f4101200141807f460d001a200141ff0171220341b7014d0440200041046a28020041014d047f100020002802000520020b2d00014100470f0b4100200341bf014b0d001a200041046a280200200141ff017141ca7e6a22014d047f100020002802000520020b20016a2d00004100470b0b2c002000200220016b22021029200028020020002802046a2001200210081a2000200028020420026a3602040b9e0201077f02402001450d002000410c6a2107200041106a2105200041046a21060340200528020022022007280200460d01200241786a28020020014904401000200528020021020b200241786a2203200328020020016b220136020020010d01200520033602002000410120062802002002417c6a28020022016b2202102a220341016a20024138491b2204200628020022086a102b2004200120002802006a22046a2004200820016b100d1a0240200241374d0440200028020020016a200241406a3a00000c010b200341f7016a220441ff014d0440200028020020016a20043a00002000280200200120036a6a210103402002450d02200120023a0000200241087621022001417f6a21010c000b000b10000b410121010c000b000b0b1b00200028020420016a220120002802084b044020002001102c0b0b1e01017f03402000044020004108762100200141016a21010c010b0b20010b0f0020002001102c200020013602040b3901017f200028020820014904402001100b22022000280200200028020410081a20002802001a200041086a2001360200200020023602000b0b2500200041011029200028020020002802046a20013a00002000200028020441016a3602040b2b01027f2001102a220241b7016a22034180024e044010000b2000200341ff0171102d200020012002102f0b3d002000200028020420026a102b200028020020002802046a417f6a2100034020010440200020013a0000200141087621012000417f6a21000c010b0b0ba00101037f230041106b2202240020012802002103024002400240024020012802042201410146044020032c000022044100480d012000200441ff0171102d0c040b200141374b0d010b200020014180017341ff0171102d0c010b20002001102e0b2002200136020c2002200336020820022002290308370300200020022802002201200120022802046a10272000410010280b200041011028200241106a24000b830101037f02400240200150450440200142ff00560d0120002001a741ff0171102d0c020b2000418001102d0c010b024020011032220241374d0440200020024180017341ff0171102d0c010b2002102a220341b7016a22044180024f044010000b2000200441ff0171102d200020022003102f0b20002001200210330b2000410110280b3202017f017e034020002002845045044020024238862000420888842100200141016a2101200242088821020c010b0b20010b5101017e2000200028020420026a102b200028020020002802046a417f6a21000340200120038450450440200020013c0000200342388620014208888421012000417f6a2100200342088821030c010b0b0b070041b00a10130b0c002000200141186a10101a0b0c002000200141406b10101a0ba40302067f017e230041c0016b22002400100710012201100b22021002200041e0006a200041206a20022001103822014100102302400240200041e0006a10392206500d0041bc0a103a2006510440200041e0006a103b103c0c020b41c10a103a2006510440200041386a1018210220004200370348200041e0006a200141011023200041e0006a2002103d200041e0006a2001410210232000200041e0006a1039370348200041e0006a103b2101200041d0006a20021010210320002903481a200141186a200041b0016a20031010220422051014200141406b2005101420041013200310132001103c200210130c020b41d00a103a2006510440200041b0016a10182102200041e0006a200141011023200041e0006a2002103d200041e0006a103b220141186a200041386a2002101022031014200310132001103c200210130c020b41e30a103a20065104402000410036021c20004102360218200020002903183703002000103e0c020b41f60a103a2006520d00200041003602142000410336021020002000290310370308200041086a103e0c010b10000b200041c0016a24000b3401017f230041106b220324002003200236020c200320013602082003200329030837030020002003411c101c200341106a24000b850102027f017e230041106b22012400200010250240024020001026450d002000280204450d0020002802002d000041c001490d010b10000b200141086a20001045200128020c220041094f044010000b200128020821020340200004402000417f6a210020023100002003420886842103200241016a21020c010b0b200141106a240020030b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b6d01027f200010182102200042afb59bdd9e8485b9f800370310200041106a200041186a10182201104a4504402001200210140b200041286a10182102200041386a220142ecae96e4b694b9d9d0003703002001200041406b10182201104a044020000f0b20012002101420000b3301017f200041386a200041406b2201104b20011013200041286a1013200041106a200041186a2201104b20011013200010130b890301057f230041206b22022400024002400240024002402000280204450d0020002802002d000041c0014f0d00200241186a200010452000101f2103200228021822000440200228021c220420034f0d020b41002100200241106a410036020020024200370308410021030c020b200241086a10181a0c030b200241106a410036020020024200370308200420032003417f461b22034170490440200020036a21052003410a4d0d01200341106a4170712206100c21042002200336020c20022006410172360208200220043602100c020b000b200220034101743a0008200241086a41017221040b034020002005470440200420002d00003a0000200441016a2104200041016a21000c010b0b200441003a00000b024020012d0000410171450440200141003b01000c010b200128020841003a00002001410036020420012d0000410171450d00200141086a2802001a200141003602000b20012002290308370200200141086a200241106a280200360200200241086a1017200241086a1013200241206a24000bb00101047f23004190016b22012400200141086a200028020422034101756a210220002802002100200141086a103b200141d8006a20022003410171047f200228020020006a2802000520000b110000200141f8006a103f2200200141d8006a104010412000200141e8006a200141d8006a10102202104220021013200028020c200041106a28020047044010000b20002802002000280204100320001043200141d8006a1013103c20014190016a24000b29002000410036020820004200370200200041001046200041146a41003602002000420037020c20000bba0101047f230041306b22012400200141286a4100360200200141206a4200370300200141186a420037030020014200370310410121020240200120001010220328020420032d00002200410176200041017122041b2200450d0002400240200041014604402003280208200341016a20041b2c0000417f4a0d030c010b200041374b0d010b200041016a21020c010b2000102a20006a41016a21020b2001200236021020031013200141106a4104721049200141306a240020020b1300200028020820014904402000200110460b0b5201037f230041106b2202240020022001280208200141016a20012d0000220341017122041b36020820022001280204200341017620041b36020c20022002290308370300200020021030200241106a24000b1c01017f200028020c22010440200041106a20013602000b200010470b1501017f200028020022010440200020013602040b0be60101047f2001101f2204200128020422024b04401000200141046a28020021020b200128020021052000027f024002400240027f0240200204404100210120052c00002203417f4c0d012005450d030c040b41000c010b200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a210120050d010b410021030c010b410021032002200149200120046a20024b720d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b3601017f200028020820014904402001100b200028020020002802041008210220001047200041086a2001360200200020023602000b0b080020002802001a0b08002000200110310bdc0201067f200028020422012000280210220241087641fcffff07716a2103027f2001200028020822054704402001200028021420026a220441087641fcffff07716a280200200441ff07714102746a2106200041146a21042003280200200241ff07714102746a0c010b200041146a210441000b2102034020022006470440200241046a220220032802006b418020470d0120032802042102200341046a21030c010b0b20044100360200200041086a21020340200520016b410275220341034f044020012802001a200041046a2201200128020041046a2201360200200228020021050c010b0b0240200041106a027f2003410147044020034102470d024180080c010b4180040b3602000b03402001200547044020012802001a200141046a21010c010b0b200041086a22032802002101200041046a280200210203402001200247044020032001417c6a22013602000c010b0b20002802001a0bc90101077f230041406a22022400200241286a103f220320002903001048200328020c200341106a28020047044010000b0240200328020022062003280204220710042200044020024100360220200242003703182000417f4c0d01200241206a2000100c20001009220520006a22083602002002200836021c2002200536021820062007200520001005417f47044020022002280218220441016a200228021c2004417f736a10382001103d200021040b200241186a10440b20031043200241406b240020040f0b000bf90302097f027e230041e0006b22032400200341286a103f2105200341d8006a4100360200200341d0006a4200370300200341c8006a420037030020034200370340410121042000290300220c4280015a04400340200b200c8450450440200b423886200c42088884210c200241016a2102200b420888210b0c010b0b200241384f047f2002102a20026a0520020b41016a21040b20032004360240200341406b4104721049200520041041200520002903001048200528020c200541106a28020047044010000b200528020421062005280200200341406b103f21022001104021084101100c220441fe013a0000200320043602182003200441016a22003602202003200036021c200228020c200241106a280200470440100020032802182104200328021c21000b20022802042209200020046b22006a220a20022802084b047f2002200a1046200241046a2802000520090b20022802006a2004200010081a200241046a2204200428020020006a3602002002200328021c20086a20032802186b10412002200341086a20011010220010422000101302402002410c6a2200280200200241106a220128020047044010002002280200210420002802002001280200460d0110000c010b200228020021040b20062004200241046a2802001006200341186a10442002104320051043200341e0006a24000b0b54010041bc0a0b4d696e69740070616e69635f636f6e7472616374007365745f737472696e675f73746f72616765006765745f737472696e675f73746f72616765006765745f737472696e675f73746f7261676531";

    public static String BINARY = BINARY_0;

    public static final String FUNC_GET_STRING_STORAGE = "get_string_storage";

    public static final String FUNC_GET_STRING_STORAGE1 = "get_string_storage1";

    public static final String FUNC_PANIC_CONTRACT = "panic_contract";

    public static final String FUNC_SET_STRING_STORAGE = "set_string_storage";

    protected Contract_panic(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected Contract_panic(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> get_string_storage() {
        final WasmFunction function = new WasmFunction(FUNC_GET_STRING_STORAGE, Arrays.asList(), String.class);
        return executeRemoteCall(function, String.class);
    }

    public RemoteCall<String> get_string_storage1() {
        final WasmFunction function = new WasmFunction(FUNC_GET_STRING_STORAGE1, Arrays.asList(), String.class);
        return executeRemoteCall(function, String.class);
    }

    public RemoteCall<TransactionReceipt> panic_contract(String name, Uint64 value) {
        final WasmFunction function = new WasmFunction(FUNC_PANIC_CONTRACT, Arrays.asList(name,value), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> panic_contract(String name, Uint64 value, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_PANIC_CONTRACT, Arrays.asList(name,value), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<TransactionReceipt> set_string_storage(String name) {
        final WasmFunction function = new WasmFunction(FUNC_SET_STRING_STORAGE, Arrays.asList(name), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> set_string_storage(String name, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_SET_STRING_STORAGE, Arrays.asList(name), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public static RemoteCall<Contract_panic> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(Contract_panic.class, web3j, credentials, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<Contract_panic> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(Contract_panic.class, web3j, transactionManager, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<Contract_panic> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(Contract_panic.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public static RemoteCall<Contract_panic> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(Contract_panic.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public static Contract_panic load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new Contract_panic(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Contract_panic load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new Contract_panic(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
