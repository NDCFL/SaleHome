<%@ page import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*"%>
<%@ page import="java.io.OutputStream"%>
<%!Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}%>
<%
	try {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		int width = 110, height = 20;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		OutputStream os = response.getOutputStream();
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		String[] s = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
				"J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U",
				"V", "W", "X", "Y", "Z" };
				String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = "";
			if (random.nextBoolean()) {
				rand = String.valueOf(random.nextInt(10));
			} else {
				int index = random.nextInt(25);
				rand = s[index];
			}
			sRand += rand;
			g.setColor(new Color(20 + random.nextInt(10), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, 17 * i + 6, 16);
		}
		session.setAttribute("rand", sRand);
		g.dispose();

		ImageIO.write(image, "JPEG", os);
		os.flush();
		os.close();
		os = null;

		response.flushBuffer();
		out.clear();
		out = pageContext.pushBody();
	} catch (IllegalStateException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
%>
