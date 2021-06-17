import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.border.EmptyBorder;

private static class Round extends DropShadowPanel {

		/** Serial version UID. */
		private static final long serialVersionUID = 4349330263921687004L;

		public BackgroundPanel() {
			super();
			setBorder(new EmptyBorder(0,20,20,20));
		}

		/** {@inheritDoc} */
		@Override
		public boolean isOpaque() {
			return false;
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = CommonUIPainter.getGraphics2D(g);
			super.paintComponent(g2);	
			
			Insets insets = getInsets();
			int x = insets.left;
			int y = insets.top;
			int w = getWidth() - insets.left - insets.right;
			int h = getHeight() - insets.top - insets.bottom;
			g2.setColor(getBackground());
			g2.fillRoundRect(x, y, w, h, 20, 20);
		}
	