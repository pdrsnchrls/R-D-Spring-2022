import React, {useState, useEffect} from 'react';
import ClayButton from '@clayui/button';
import ClayCard from '@clayui/card';

function Game() {
    // get a random enemy
    // get user abilities
    // display user abilities and enemy stats
    // execute ability
    // win or lose state

    const abilities = ["Fight", "Run", "Dance"];

    const listAbilities = abilities.map((ability) =>
        <ClayButton type="primary" onClick={() => console.log("Hello " + ability)}>{ability}</ClayButton>
    )

    return (
        <div className="fight-background">
            <div>
                <div>
                    <ClayCard horizontal className="enemy-card">
                        <ClayCard.Row>
                            <div className="icon enemy-animation">
                                <img className="icon-img" src="./images/monster.jpg" alt="Monster"/>
                            </div>
                            <ClayCard.Description truncate={false} displayType="text">
                                <strong>Octopus</strong> Health 50hp<br/>
                                Level 1
                            </ClayCard.Description>
                        </ClayCard.Row>
                    </ClayCard>
                </div>

                <div>
                    <ClayCard horizontal className="user-card">
                        <ClayCard.Row>
                            <div className="icon user-animation">
                                <img className="icon-img" src="./images/main_character.jpg" alt="User image"/>
                            </div>
                            <ClayCard.Description truncate={false} displayType="text">
                                <strong>Player 1:</strong> Health 100hp<br/>
                                {listAbilities}
                            </ClayCard.Description>
                        </ClayCard.Row>
                    </ClayCard>
                </div>
            </div>
        </div>
    );
}

export default Game;