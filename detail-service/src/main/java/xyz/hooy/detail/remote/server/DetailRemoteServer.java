package xyz.hooy.detail.remote.server;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hooy.detail.api.remote.DetailRemote;
import xyz.hooy.detail.api.entity.Detail;
import xyz.hooy.detail.service.DetailService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/remote/detail")
public class DetailRemoteServer implements DetailRemote {

    private final DetailService detailService;

    @Override
    @GetMapping("/getDetailById/{id}")
    public Detail getDetailById(@PathVariable("id") Long id) {
        return detailService.getDetailById(id);
    }

    @Override
    @GetMapping("/getDetailNameById/{id}")
    public String getDetailNameById(@PathVariable("id") Long id) {
        return detailService.getDetailNameById(id);
    }

    @Override
    @GetMapping("/getDetailIntroductionById/{id}")
    public String getDetailIntroductionById(@PathVariable("id") Long id) {
        return detailService.getDetailIntroductionById(id);
    }

    @Override
    @GetMapping("/getDetailByOrderId/{orderId}")
    public Detail getDetailByOrderId(@PathVariable("orderId") Long orderId) {
        return detailService.getDetailByOrderId(orderId);
    }
}
