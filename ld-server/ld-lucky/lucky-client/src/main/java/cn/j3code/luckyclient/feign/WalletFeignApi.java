package cn.j3code.luckyclient.feign;

import cn.j3code.config.constant.ServerNameConstants;
import cn.j3code.luckyclient.feign.form.UpdateWalletForm;
import cn.j3code.luckyclient.feign.vo.WalletMoney;
import cn.j3code.luckyclient.feign.vo.WalletUpdateResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-14 21:25
 **/
@FeignClient(name = ServerNameConstants.WALLET,path = "/v1/feign/wallet")
public interface WalletFeignApi {

    @PostMapping("/updateWallet")
    WalletUpdateResultVO updateBalance(@RequestBody UpdateWalletForm form);

    @GetMapping("/initUserWallet")
    void initUserWallet(@RequestParam("userId") Long userId);

    @GetMapping("/getUserWallet")
    WalletMoney getUserWallet(@RequestParam("userId") Long userId);

}
