package com.liferay.react.game.core.service.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.react.game.core.service.model.Ability;
import com.liferay.react.game.core.service.model.PlayerEnemyAbility;
import com.liferay.react.game.core.service.service.AbilityLocalService;
import com.liferay.react.game.core.service.service.PlayerEnemyAbilityLocalService;
import com.liferay.react.game.core.service.service.persistence.PlayerEnemyAbilityFinder;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component(service = PlayerEnemyAbilityFinder.class)
public class PlayerEnemyAbilityFinderImpl extends PlayerEnemyAbilityFinderBaseImpl implements PlayerEnemyAbilityFinder {
    public List<Ability> findByPlayerOrEnemyId(long playerOrEnemyId) {

        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PlayerEnemyAbility.class, ClassLoader.getSystemClassLoader())
            .add(RestrictionsFactoryUtil.eq("playerOrEnemyId", playerOrEnemyId))
            .setProjection(ProjectionFactoryUtil.property("abilityId"));

        List<Long> abilityIds = _playerEnemyAbilityLocalService.dynamicQuery(dynamicQuery);

        List<Ability> abilities = new ArrayList<>();

        for (Long abilityId : abilityIds) {
            Ability ability = _abilityLocalService.fetchAbility(abilityId);

            if (Objects.nonNull(ability)) {
                abilities.add(ability);
            }
        }

        return abilities;
    }

    @Reference
    private AbilityLocalService _abilityLocalService;

    @Reference
    private PlayerEnemyAbilityLocalService _playerEnemyAbilityLocalService;
}
