package us.vchain.jvcn;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.1.1.
 */
@SuppressWarnings("all")
class AssetsRelay extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b506040516020806111a98339810180604052810190808051906020019092919050505080600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555042600181905550506110de806100cb6000396000f3006080604052600436106100d0576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806328f7f9b8146100d557806338052e271461011a57806354df1eab146101ab5780636c6071aa146101e657806375f890ab146102525780638da5cb5b14610295578063a0aead4d146102ec578063bb9c6c3e14610317578063bf91e82f146103a7578063c9e07f09146103f6578063cf09e0d01461043b578063d6ce25a914610466578063ddfe5b2d14610500578063ec05818614610557575b600080fd5b3480156100e157600080fd5b50610118600480360381019080803590602001908201803590602001919091929391929390803590602001909291905050506105fd565b005b34801561012657600080fd5b5061015b600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506106cd565b604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838152602001828152602001935050505060405180910390f35b3480156101b757600080fd5b506101e46004803603810190808035906020019082018035906020019190919293919293905050506107eb565b005b3480156101f257600080fd5b506101fb6108b5565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561023e578082015181840152602081019050610223565b505050509050019250505060405180910390f35b34801561025e57600080fd5b50610293600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506109d3565b005b3480156102a157600080fd5b506102aa610a6d565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156102f857600080fd5b50610301610a92565b6040518082815260200191505060405180910390f35b34801561032357600080fd5b50610350600480360381019080803590602001908201803590602001919091929391929390505050610b5a565b604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184815260200183815260200182815260200194505050505060405180910390f35b3480156103b357600080fd5b506103e0600480360381019080803590602001908201803590602001919091929391929390505050610c75565b6040518082815260200191505060405180910390f35b34801561040257600080fd5b5061043960048036038101908080359060200190820180359060200191909192939192939080359060200190929190505050610d65565b005b34801561044757600080fd5b50610450610e38565b6040518082815260200191505060405180910390f35b34801561047257600080fd5b506104a960048036038101908080359060200190820180359060200191909192939192939080359060200190929190505050610e3e565b604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184815260200183815260200182815260200194505050505060405180910390f35b34801561050c57600080fd5b50610515610f61565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561056357600080fd5b5061058260048036038101908080359060200190929190505050610f87565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156105c25780820151818401526020810190506105a7565b50505050905090810190601f1680156105ef5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166328f7f9b88484846040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200183815260200182810382528585828181526020019250808284378201915050945050505050600060405180830381600087803b1580156106b057600080fd5b505af11580156106c4573d6000803e3d6000fd5b50505050505050565b6000806000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166338052e27856040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050606060405180830381600087803b15801561078f57600080fd5b505af11580156107a3573d6000803e3d6000fd5b505050506040513d60608110156107b957600080fd5b810190808051906020019092919080519060200190929190805190602001909291905050509250925092509193909250565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166354df1eab83836040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825284848281815260200192506020028082843782019150509350505050600060405180830381600087803b15801561089957600080fd5b505af11580156108ad573d6000803e3d6000fd5b505050505050565b6060600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16636c6071aa6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401600060405180830381600087803b15801561093d57600080fd5b505af1158015610951573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f82011682018060405250602081101561097b57600080fd5b81019080805164010000000081111561099357600080fd5b828101905060208101848111156109a957600080fd5b81518560208202830111640100000000821117156109c657600080fd5b5050929190505050905090565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff161415610a6a5780600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a0aead4d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015610b1a57600080fd5b505af1158015610b2e573d6000803e3d6000fd5b505050506040513d6020811015610b4457600080fd5b8101908080519060200190929190505050905090565b600080600080600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663bb9c6c3e87876040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825284848281815260200192508082843782019150509350505050608060405180830381600087803b158015610c0b57600080fd5b505af1158015610c1f573d6000803e3d6000fd5b505050506040513d6080811015610c3557600080fd5b8101908080519060200190929190805190602001909291908051906020019092919080519060200190929190505050935093509350935092959194509250565b6000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663bf91e82f84846040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825284848281815260200192508082843782019150509350505050602060405180830381600087803b158015610d2257600080fd5b505af1158015610d36573d6000803e3d6000fd5b505050506040513d6020811015610d4c57600080fd5b8101908080519060200190929190505050905092915050565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663c9e07f098484846040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200183815260200182810382528585828181526020019250602002808284378201915050945050505050600060405180830381600087803b158015610e1b57600080fd5b505af1158015610e2f573d6000803e3d6000fd5b50505050505050565b60015481565b600080600080600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663d6ce25a98888886040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200183815260200182810382528585828181526020019250808284378201915050945050505050608060405180830381600087803b158015610ef757600080fd5b505af1158015610f0b573d6000803e3d6000fd5b505050506040513d6080811015610f2157600080fd5b8101908080519060200190929190805190602001909291908051906020019092919080519060200190929190505050935093509350935093509350935093565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6060600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663e9d1e616836040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050600060405180830381600087803b15801561101a57600080fd5b505af115801561102e573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f82011682018060405250602081101561105857600080fd5b81019080805164010000000081111561107057600080fd5b8281019050602081018481111561108657600080fd5b81518560018202830111640100000000821117156110a357600080fd5b505092919050505090509190505600a165627a7a723058207c812fd021b498b8fcefef10ee5b13e3c8895bf96e995ecc1a865e341eb91ae30029";

    private static final String FUNC_OWNER = "owner";

    private static final String FUNC_CREATEDAT = "createdAt";

    private static final String FUNC_ASSETSCONTRACT = "assetsContract";

    private static final String FUNC_SETCONTRACT = "setContract";

    private static final String FUNC_SETPUBLISHERLEVEL = "setPublisherLevel";

    private static final String FUNC_DISABLEPUBLISHER = "disablePublisher";

    private static final String FUNC_GETPUBLISHERS = "getPublishers";

    private static final String FUNC_GETPUBLISHERBYADDRESS = "getPublisherByAddress";

    private static final String FUNC_SIGN = "sign";

    private static final String FUNC_VERIFY = "verify";

    private static final String FUNC_VERIFYBYINDEX = "verifyByIndex";

    private static final String FUNC_GETASSETCOUNT = "getAssetCount";

    private static final String FUNC_GETASSETCOUNTFORHASH = "getAssetCountForHash";

    private static final String FUNC_GETHASHBYINDEX = "getHashByIndex";

    private static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<>();
    }

    @Deprecated
    protected AssetsRelay(final String contractAddress, final Web3j web3j, final Credentials credentials, final BigInteger gasPrice, final BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private AssetsRelay(final String contractAddress, final Web3j web3j, final Credentials credentials, final ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AssetsRelay(final String contractAddress, final Web3j web3j, final TransactionManager transactionManager, final BigInteger gasPrice, final BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    private AssetsRelay(final String contractAddress, final Web3j web3j, final TransactionManager transactionManager, final ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER,
            Arrays.<Type>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> createdAt() {
        final Function function = new Function(FUNC_CREATEDAT,
            Arrays.<Type>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> assetsContract() {
        final Function function = new Function(FUNC_ASSETSCONTRACT,
            Arrays.<Type>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setContract(final String aContract) {
        final Function function = new Function(
            FUNC_SETCONTRACT,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(aContract)),
            Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setPublisherLevel(final List<String> publicKeys, final BigInteger level) {
        final Function function = new Function(
            FUNC_SETPUBLISHERLEVEL,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<>(
                    org.web3j.abi.Utils.typeMap(publicKeys, org.web3j.abi.datatypes.Address.class)),
                new org.web3j.abi.datatypes.generated.Int256(level)),
            Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> disablePublisher(final List<String> publicKeys) {
        final Function function = new Function(
            FUNC_DISABLEPUBLISHER,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<>(
                org.web3j.abi.Utils.typeMap(publicKeys, org.web3j.abi.datatypes.Address.class))),
            Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<List> getPublishers() {
        final Function function = new Function(FUNC_GETPUBLISHERS,
            Arrays.<Type>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteCall<>(
            new Callable<List>() {
                @Override
                public List call() throws Exception {
                    final List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                    return convertToNative(result);
                }
            });
    }

    public RemoteCall<Tuple3<String, BigInteger, BigInteger>> getPublisherByAddress(final String publicKey) {
        final Function function = new Function(FUNC_GETPUBLISHERBYADDRESS,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(publicKey)),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<>(
            new Callable<Tuple3<String, BigInteger, BigInteger>>() {
                @Override
                public Tuple3<String, BigInteger, BigInteger> call() throws Exception {
                    final List<Type> results = executeCallMultipleValueReturn(function);
                    return new Tuple3<>(
                        (String) results.get(0).getValue(),
                        (BigInteger) results.get(1).getValue(),
                        (BigInteger) results.get(2).getValue());
                }
            });
    }

    public RemoteCall<TransactionReceipt> sign(final String hash, final BigInteger status) {
        final Function function = new Function(
            FUNC_SIGN,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(hash),
                new org.web3j.abi.datatypes.generated.Int256(status)),
            Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple4<String, BigInteger, BigInteger, BigInteger>> verify(final String hash) {
        final Function function = new Function(FUNC_VERIFY,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(hash)),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<>(
            new Callable<Tuple4<String, BigInteger, BigInteger, BigInteger>>() {
                @Override
                public Tuple4<String, BigInteger, BigInteger, BigInteger> call() throws Exception {
                    final List<Type> results = executeCallMultipleValueReturn(function);
                    return new Tuple4<>(
                        (String) results.get(0).getValue(),
                        (BigInteger) results.get(1).getValue(),
                        (BigInteger) results.get(2).getValue(),
                        (BigInteger) results.get(3).getValue());
                }
            });
    }

    public RemoteCall<Tuple4<String, BigInteger, BigInteger, BigInteger>> verifyByIndex(final String hash, final BigInteger assetIndex) {
        final Function function = new Function(FUNC_VERIFYBYINDEX,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(hash),
                new org.web3j.abi.datatypes.generated.Uint256(assetIndex)),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<>(
            new Callable<Tuple4<String, BigInteger, BigInteger, BigInteger>>() {
                @Override
                public Tuple4<String, BigInteger, BigInteger, BigInteger> call() throws Exception {
                    final List<Type> results = executeCallMultipleValueReturn(function);
                    return new Tuple4<>(
                        (String) results.get(0).getValue(),
                        (BigInteger) results.get(1).getValue(),
                        (BigInteger) results.get(2).getValue(),
                        (BigInteger) results.get(3).getValue());
                }
            });
    }

    public RemoteCall<BigInteger> getAssetCount() {
        final Function function = new Function(FUNC_GETASSETCOUNT,
            Arrays.<Type>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getAssetCountForHash(final String hash) {
        final Function function = new Function(FUNC_GETASSETCOUNTFORHASH,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(hash)),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getHashByIndex(final BigInteger hashIndex) {
        final Function function = new Function(FUNC_GETHASHBYINDEX,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(hashIndex)),
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static AssetsRelay load(final String contractAddress, final Web3j web3j, final Credentials credentials, final BigInteger gasPrice, final BigInteger gasLimit) {
        return new AssetsRelay(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AssetsRelay load(final String contractAddress, final Web3j web3j, final TransactionManager transactionManager, final BigInteger gasPrice, final BigInteger gasLimit) {
        return new AssetsRelay(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AssetsRelay load(final String contractAddress, final Web3j web3j, final Credentials credentials, final ContractGasProvider contractGasProvider) {
        return new AssetsRelay(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AssetsRelay load(final String contractAddress, final Web3j web3j, final TransactionManager transactionManager, final ContractGasProvider contractGasProvider) {
        return new AssetsRelay(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AssetsRelay> deploy(final Web3j web3j, final Credentials credentials, final ContractGasProvider contractGasProvider, final String aContract) {
        final String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(aContract)));
        return deployRemoteCall(AssetsRelay.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<AssetsRelay> deploy(final Web3j web3j, final TransactionManager transactionManager, final ContractGasProvider contractGasProvider, final String aContract) {
        final String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(aContract)));
        return deployRemoteCall(AssetsRelay.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<AssetsRelay> deploy(final Web3j web3j, final Credentials credentials, final BigInteger gasPrice, final BigInteger gasLimit, final String aContract) {
        final String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(aContract)));
        return deployRemoteCall(AssetsRelay.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<AssetsRelay> deploy(final Web3j web3j, final TransactionManager transactionManager, final BigInteger gasPrice, final BigInteger gasLimit, final String aContract) {
        final String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(aContract)));
        return deployRemoteCall(AssetsRelay.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Override
    protected String getStaticDeployedAddress(final String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(final String networkId) {
        return _addresses.get(networkId);
    }
}
