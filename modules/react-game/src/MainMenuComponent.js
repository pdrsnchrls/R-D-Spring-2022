import React, {useState} from 'react';
import ClayButton from '@clayui/button';
import ClayModal, {useModal} from '@clayui/modal';

function MainMenu(props) {
	const [visible, setVisible] = useState(false);
	const {observer, onClose} = useModal({
		onClose: () => setVisible(false),
	});

	return (
		<div className="menu-container">
			<div className="overflow-container">
				<div>
					{visible && (
						<ClayModal
							observer={observer}
							size="lg"
						>
							<ClayModal.Header>
								How To Play
							</ClayModal.Header>
							<ClayModal.Body>
								Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Morbi blandit cursus risus at ultrices mi tempus imperdiet nulla. Ut consequat semper viverra nam libero justo laoreet. At urna condimentum mattis pellentesque id. Pretium quam vulputate dignissim suspendisse in est. Nulla aliquet enim tortor at auctor urna. Placerat duis ultricies lacus sed turpis tincidunt id aliquet. Enim blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Leo vel fringilla est ullamcorper eget nulla facilisi. Risus feugiat in ante metus dictum at tempor. Integer quis auctor elit sed. Augue eget arcu dictum varius duis at consectetur lorem donec. Sed risus ultricies tristique nulla aliquet. Porta lorem mollis aliquam ut. At elementum eu facilisis sed odio morbi quis commodo. Gravida arcu ac tortor dignissim convallis aenean et tortor. Ornare quam viverra orci sagittis eu volutpat odio.
							</ClayModal.Body>
							<ClayModal.Footer last={<ClayButton onClick={onClose}>{"Let's Play"}</ClayButton>} />
						</ClayModal>
					)}
				</div>
				<img src="https://dm0qx8t0i9gc9.cloudfront.net/thumbnails/video/GTYSdDW/cartoon-cloud-animation-with-loop_v211ezdke_thumbnail-1080_01.png" width="100%" />
				<ul className="menu-list">
					<li className="menu-item">
						<h1>Pokemon Simulator</h1>
					</li>
					<li className="menu-item">
						<ClayButton type="submit" onClick={() => <MainMenu />}>{Liferay.Language.get("play-game")}</ClayButton>
					</li>
					<li className="menu-item">
						<ClayButton type="submit" onClick={() => setVisible(true)}>{Liferay.Language.get("how-to-play")}</ClayButton>
					</li>
				</ul>
			</div>
		</div>
	);
}

export default MainMenu;