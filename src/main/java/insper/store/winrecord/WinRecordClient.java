package insper.store.winrecord;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "store-account")
public interface WinRecordClient {
    @GetMapping("/accounts/{id}")
    ResponseEntity<Void> checkAccountExists(@PathVariable("id") String id);
}