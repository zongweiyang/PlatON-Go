#include <platon/platon.hpp>
#include <string>
using namespace platon;

extern char const string_storage[] = "stringstorage";
extern char const string_contract_ower[] = "contract_ower";

CONTRACT ContractMigrate : public platon::Contract{
   public:
      PLATON_EVENT1(transfer,std::string,std::string)

      ACTION void init(){
          contract_ower.self() = platon_caller().toString();
      }

      /**
       * 合约升级
       * 内置 platon_migrate 函数 return_address 参数被写入新合约地址
       * init_arg 参数为  magic number +  RLP(code, RLP("init", init_paras...))
       * transfer_value 为转到新合约地址的金额，gas_value 为预估消耗的 gas
       */  
      ACTION std::string migrate_contract(const bytes &init_arg, uint64_t transfer_value, uint64_t gas_value){
            if (contract_ower.self() != platon_caller().toString()){
                return "invalid address";
            }
            Address return_address;
            platon_migrate_contract(return_address, init_arg, transfer_value, gas_value);
            PLATON_EMIT_EVENT1(transfer,return_address.toString(),return_address.toString());
            DEBUG("new contract address:", return_address.toString());
            stringstorage.self() = return_address.toString();
            return return_address.toString();
      }

      CONST std::string get_new_contract_addr(){
          return stringstorage.self();
      }
   private:
      platon::StorageType<string_storage, std::string> stringstorage;
      platon::StorageType<string_contract_ower, std::string> contract_ower;
};

PLATON_DISPATCH(ContractMigrate, (init)(migrate_contract)(get_new_contract_addr))
