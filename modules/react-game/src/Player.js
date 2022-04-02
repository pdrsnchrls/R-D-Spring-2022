import ClayCard from "@clayui/card";
import React, {useEffect, useState} from 'react';
import ClayButton from "@clayui/button";

function Player() {
    const abilities = ["Fight", "Run", "Dance"];

    const listAbilities = abilities.map((ability) =>
        <ClayButton type="primary" onClick={() => console.log("Hello " + ability)}>{ability}</ClayButton>
    )

    const [player, setPlayer] = useState([]);

    useEffect( () => {
        fetch('/o/game-rest/v1.0/player/40714', {
            headers: {
                'x-csrf-token': Liferay.authToken
            }
        })
            .then((res) => res.json())
            .then((json) => {
                setPlayer(json)
            })
    })

    return (
        <ClayCard horizontal className="user-card">
            <ClayCard.Row>
                <div className="icon user-animation">
                    <img className="icon-img" src="./images/main_character.jpg" alt="User image"/>
                </div>
                <ClayCard.Description truncate={false} displayType="text">
                    <strong>{player.name}:</strong> Health {player.hitPoints}hp<br/>
                    Level: {player.level}
                    {listAbilities}
                </ClayCard.Description>
            </ClayCard.Row>
        </ClayCard>
    );
}

export default Player