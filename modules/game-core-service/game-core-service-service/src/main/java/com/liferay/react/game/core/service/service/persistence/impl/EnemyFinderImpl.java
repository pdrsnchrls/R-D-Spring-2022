package com.liferay.react.game.core.service.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.react.game.core.service.model.Enemy;
import com.liferay.react.game.core.service.model.PlayerEnemyAbility;
import com.liferay.react.game.core.service.service.EnemyLocalServiceUtil;
import com.liferay.react.game.core.service.service.persistence.EnemyFinder;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@Component(service= EnemyFinder.class)
public class EnemyFinderImpl extends EnemyFinderBaseImpl implements EnemyFinder {
    public Enemy findRandomEnemyByLevel(int level) {
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PlayerEnemyAbility.class, ClassLoader.getSystemClassLoader())
                .add(RestrictionsFactoryUtil.eq("level", level))
                .setProjection(ProjectionFactoryUtil.property("enemyId"));

        List<Long> enemyIds = EnemyLocalServiceUtil.dynamicQuery(dynamicQuery);

        if (enemyIds.size() > 1) {
            Random random = new Random();

            long randomEnemyId = enemyIds.get(random.nextInt(enemyIds.size()) - 1);

            return getEnemy(randomEnemyId);

        } else if (enemyIds.size() == 1) {
            return getEnemy(enemyIds.get(0));
        }
        else {
            return null;
        }
    }

    private Enemy getEnemy(long enemyId) {
        Enemy enemy = EnemyLocalServiceUtil.fetchEnemy(enemyId);

        if (Objects.nonNull(enemy)) {
            return enemy;
        }

        return null;
    }
}
