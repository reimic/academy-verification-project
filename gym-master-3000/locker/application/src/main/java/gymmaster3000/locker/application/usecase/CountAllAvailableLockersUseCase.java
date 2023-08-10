package gymmaster3000.locker.application.usecase;

import gymmaster3000.locker.application.port.FindAllLockersPort;
import gymmaster3000.locker.domain.entity.Locker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CountAllAvailableLockersUseCase {

    private final FindAllLockersPort port;

    @Transactional
    public long apply(CountAllAvailableLockersQuery query) {
        return port.findAll()
                   .stream()
                   .filter(Locker::isAvailable)
                   .count();
    }

    public record CountAllAvailableLockersQuery() {

    }

}
