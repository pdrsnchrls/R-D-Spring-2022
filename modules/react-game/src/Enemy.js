import ClayCard from "@clayui/card";
import React, {useState, useEffect} from 'react';

function Enemy() {
    const [enemy, setEnemy] = useState([]);

    useEffect( () => {
        fetch('/o/game-rest/v1.0/enemy/40712', {
            headers: {
                'x-csrf-token': Liferay.authToken
            }
        })
            .then((res) => res.json())
            .then((json) => {
                setEnemy(json)
            })
    })

    return (
        <ClayCard horizontal className="enemy-card">
            <ClayCard.Row>
                <div className="icon enemy-animation">
                    <img className="icon-img" src={enemy.image} alt="Monster"/>
                </div>
                <ClayCard.Description truncate={false} displayType="text">
                    <strong>{enemy.name}:</strong> Health {enemy.hitPoints} hp<br/>
                    Level {enemy.level}
                </ClayCard.Description>
            </ClayCard.Row>
        </ClayCard>
    )
}

export default Enemy