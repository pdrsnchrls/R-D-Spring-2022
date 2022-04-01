package com.liferay.react.game.core.service.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.react.game.core.service.model.PlayerEnemyAbility;
import com.liferay.react.game.core.service.service.PlayerEnemyAbilityLocalServiceUtil;
import com.liferay.react.game.core.service.service.persistence.PlayerEnemyAbilityFinder;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component(service = PlayerEnemyAbilityFinder.class)
public class PlayerEnemyAbilityFinderImpl extends PlayerEnemyAbilityFinderBaseImpl implements PlayerEnemyAbilityFinder {

    public List<PlayerEnemyAbility> findByPlayerOrEnemyId(long playerOrEnemyId) {
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PlayerEnemyAbility.class, getClassLoader())
            .add(RestrictionsFactoryUtil.eq("playerOrEnemyId", playerOrEnemyId))
            .setProjection(ProjectionFactoryUtil.property("playerEnemyAbilityId"));

        List<Long> playerEnemyAbilityIds = PlayerEnemyAbilityLocalServiceUtil.dynamicQuery(dynamicQuery);

        List<PlayerEnemyAbility> playerEnemyAbilities = new ArrayList<>();

        for (Long playerEnemyAbilityId : playerEnemyAbilityIds) {
            PlayerEnemyAbility playerEnemyAbility = PlayerEnemyAbilityLocalServiceUtil.fetchPlayerEnemyAbility(playerEnemyAbilityId);

            if (Objects.nonNull(playerEnemyAbility)) {
                playerEnemyAbilities.add(playerEnemyAbility);
            }
        }

        return playerEnemyAbilities;
    }

}
