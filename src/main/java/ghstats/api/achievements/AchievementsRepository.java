package ghstats.api.achievements;

import ghstats.api.achievements.api.AchievementUnlocked;
import ghstats.api.integrations.github.api.UserName;
import org.springframework.data.util.Pair;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;
import java.util.Map;

interface AchievementsRepository {
    Mono<Long> saveAchievement(String achievementId, AchievementUnlocked achievementUnlocked);

    Flux<UnlockData> getLastUnlocked(int limit);

    Mono<Map<String, Long>> getUnlockedStats();

    Mono<Map<UserName, Long>> getScoreboard();

    Flux<Pair<String, String>> getUnlockedAchievements(UserName userName);

    record UnlockData(UserName user, String achievementId, ZonedDateTime unlockedAt) {
    }
}
