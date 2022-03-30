import React, {useState, useEffect} from 'react';
import ClayButton from '@clayui/button';
import ClayModal, {useModal} from '@clayui/modal';
import ClayCard from '@clayui/card'

function Load() {
	const [window, setWindow] = useState("main");

	switch (window) {
		case "play":
			return (
				<div className="menu-container">
					<div className="overflow-container">
						<h1> Hello! </h1>
					</div>
				</div>
			);
			break;
		case "help":
			return (
				<div className="menu-container">
					<div className="overflow-container">
						<img src="https://dm0qx8t0i9gc9.cloudfront.net/thumbnails/video/GTYSdDW/cartoon-cloud-animation-with-loop_v211ezdke_thumbnail-1080_01.png" width="100%" />
						<ClayCard className="how-to-play">
							<ClayCard.Body className="text">
								<ClayCard.Description displayType="title">
									How to Play
								</ClayCard.Description>
								<ClayCard.Description displayType="text" truncate={false} className="body">
									Welcome to the Pokemon Simulator! This is a very simple game that requires no skill. Just click buttons and you might win!
									<br /><br />
									Created by Charles Pederson - Copyright 2022
								</ClayCard.Description>
								<ClayButton type="submit" onClick={() => setWindow("main")}>{Liferay.Language.get("lets-play")}</ClayButton>
							</ClayCard.Body>
						</ClayCard>
					</div>
				</div>
			);
		default:
			return (
				<div className="menu-container">
					<div className="overflow-container">
						<img src="https://dm0qx8t0i9gc9.cloudfront.net/thumbnails/video/GTYSdDW/cartoon-cloud-animation-with-loop_v211ezdke_thumbnail-1080_01.png" width="100%" />
						<ClayCard className="menu-card">
							<ClayCard.Body>
								<ClayCard.Description displayType="title" className="menu-list">
									Pokemon Simulator<br/><br/>
									<ClayButton className="menu-item" type="submit" onClick={() => setWindow("play")}>
										{Liferay.Language.get("play-game")}
									</ClayButton><br/><br/>
									<ClayButton className="menu-item" type="submit" onClick={() => setWindow("help")}>{Liferay.Language.get("how-to-play")}</ClayButton>
								</ClayCard.Description>
							</ClayCard.Body>
						</ClayCard>
					</div>
				</div>
			)
	}
}

function MainMenu(props) {
	return (
		<Load/>
	);
}

export default MainMenu;