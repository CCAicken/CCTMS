package util;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class OrderMapTest {

	/**
	 * �жϵ��Ƿ��ڶ������
	 * 
	 * @param point
	 *            ����
	 * @param pts
	 *            ����εĶ���
	 * @return ���ڶ�����ڷ���true,���򷵻�false
	 */
	public static boolean IsPtInPoly(Point2D.Double point,
			List<Point2D.Double> pts) {

		int N = pts.size();
		boolean boundOrVertex = true; // �����λ�ڶ���εĶ������ϣ�Ҳ�������ڶ�����ڣ�ֱ�ӷ���true
		int intersectCount = 0;// cross points count of x
		double precision = 2e-10; // �������ͼ���ʱ����0�Ƚ�ʱ����ݲ�
		Point2D.Double p1, p2;// neighbour bound vertices
		Point2D.Double p = point; // ��ǰ��

		p1 = pts.get(0);// left vertex
		for (int i = 1; i <= N; ++i) {// check all rays
			if (p.equals(p1)) {
				return boundOrVertex;// p is an vertex
			}

			p2 = pts.get(i % N);// right vertex
			if (p.x < Math.min(p1.x, p2.x) || p.x > Math.max(p1.x, p2.x)) {// ray
																			// is
																			// outside
																			// of
																			// our
																			// interests
				p1 = p2;
				continue;// next ray left point
			}

			if (p.x > Math.min(p1.x, p2.x) && p.x < Math.max(p1.x, p2.x)) {// ray
																			// is
																			// crossing
																			// over
																			// by
																			// the
																			// algorithm
																			// (common
																			// part
																			// of)
				if (p.y <= Math.max(p1.y, p2.y)) {// x is before of ray
					if (p1.x == p2.x && p.y >= Math.min(p1.y, p2.y)) {// overlies
																		// on a
																		// horizontal
																		// ray
						return boundOrVertex;
					}

					if (p1.y == p2.y) {// ray is vertical
						if (p1.y == p.y) {// overlies on a vertical ray
							return boundOrVertex;
						} else {// before ray
							++intersectCount;
						}
					} else {// cross point on the left side
						double xinters = (p.x - p1.x) * (p2.y - p1.y)
								/ (p2.x - p1.x) + p1.y;// cross point of y
						if (Math.abs(p.y - xinters) < precision) {// overlies on
																	// a ray
							return boundOrVertex;
						}

						if (p.y < xinters) {// before ray
							++intersectCount;
						}
					}
				}
			} else {// special case when ray is crossing through the vertex
				if (p.x == p2.x && p.y <= p2.y) {// p crossing over p2
					Point2D.Double p3 = pts.get((i + 1) % N); // next vertex
					if (p.x >= Math.min(p1.x, p3.x)
							&& p.x <= Math.max(p1.x, p3.x)) {// p.x lies between
																// p1.x & p3.x
						++intersectCount;
					} else {
						intersectCount += 2;
					}
				}
			}
			p1 = p2;// next ray left point
		}

		if (intersectCount % 2 == 0) {// ż���ڶ������
			return false;
		} else { // �����ڶ������
			return true;
		}

	}

	// ����һ�����Ƿ��ڶ������
	public static void main(String[] args) {

		// Point2D.Double point = new Point2D.Double(116.404072, 39.916605);
		Point2D.Double point = new Point2D.Double(116.395, 39.913);

		List<Point2D.Double> pts = new ArrayList<Point2D.Double>();
		pts.add(new Point2D.Double(116.395, 39.910));
		pts.add(new Point2D.Double(116.394, 39.914));
		pts.add(new Point2D.Double(116.403, 39.920));
		pts.add(new Point2D.Double(116.402, 39.914));
		pts.add(new Point2D.Double(116.410, 39.913));

		if (IsPtInPoly(point, pts)) {
			System.out.println("���ڶ������");
		} else {
			System.out.println("���ڶ������");
		}
	}
}
