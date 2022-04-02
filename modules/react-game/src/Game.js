import React, {useState, useEffect} from 'react';
import ClayButton from '@clayui/button';
import Enemy from './Enemy'
import Player from './Player'

function Game() {
    // get a random enemy
    // get user abilities
    // display user abilities and enemy stats
    // execute ability
    // win or lose state

    return (
        <div className="fight-background">
            <div>
                <div>
                    <Enemy />
                </div>

                <div>
                    <Player />
                </div>
            </div>
        </div>
    );
}

export default Game;