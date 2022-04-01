package com.liferay.react.game.core.service.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.react.game.core.service.model.Enemy;
import com.liferay.react.game.core.service.model.PlayerEnemyAbility;
import com.liferay.react.game.core.service.service.EnemyLocalService;
import com.liferay.react.game.core.service.service.persistence.EnemyFinder;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.Random;

@Component(service= EnemyFinder.class)
public class EnemyFinderImpl extends BasePersistenceImpl<Enemy> implements EnemyFinder {
    public Enemy findRandomEnemyByLevel(int level) {
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PlayerEnemyAbility.class, ClassLoader.getSystemClassLoader())
                .add(RestrictionsFactoryUtil.eq("level", level))
                .setProjection(ProjectionFactoryUtil.property("enemyId"));

        List<Long> enemyIds = _enemyLocalService.dynamicQuery(dynamicQuery);

        if (enemyIds.size() > 1) {
            Random random = new Random();

            long randomEnemyId = enemyIds.get(random.nextInt(enemyIds.size()) - 1);

            return _enemyLocalService.fetchEnemy(randomEnemyId);

        } else if (enemyIds.size() == 1) {
            return _enemyLocalService.fetchEnemy(enemyIds.get(0));
        }
        else {
            return null;
        }
    }

    @Reference
    private EnemyLocalService _enemyLocalService;
}
