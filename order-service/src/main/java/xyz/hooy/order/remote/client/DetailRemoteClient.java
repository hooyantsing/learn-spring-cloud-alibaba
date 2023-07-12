package xyz.hooy.order.remote.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import xyz.hooy.detail.api.entity.Detail;
import xyz.hooy.detail.api.remote.DetailRemote;

@Component
public class DetailRemoteClient implements DetailRemote {

    private final RestTemplate detailRemote;

    public DetailRemoteClient(@Qualifier("detailRemote") RestTemplate detailRemote) {
        this.detailRemote = detailRemote;
    }

    @Override
    public Detail getDetailById(Long id) {
        return detailRemote.getForObject("http://detail-service/remote/detail/getDetailById/" + id, Detail.class);
    }

    @Override
    public String getDetailNameById(Long id) {
        return detailRemote.getForObject("http://detail-service/remote/detail/getDetailNameById/" + id, String.class);
    }

    @Override
    public String getDetailIntroductionById(Long id) {
        return detailRemote.getForObject("http://detail-service/remote/detail/getDetailIntroductionById/" + id, String.class);
    }

    @Override
    public Detail getDetailByOrderId(Long orderId) {
        return detailRemote.getForObject("http://detail-service/remote/detail/getDetailByOrderId/" + orderId, Detail.class);
    }
}
