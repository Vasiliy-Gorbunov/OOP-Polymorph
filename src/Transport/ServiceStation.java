package Transport;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation {
    private static Queue<Transport> queue = new LinkedList<Transport>();

    public static void addToQueue(Transport transport) {
        if (transport.getClass() != Bus.class) {
            queue.offer(transport);
        }
        else {
            System.out.println("Автобусы не нуждаются в техобслуживании");
        }
    }

    public static void conductService() {
        if (queue.peek() != null) {
            System.out.println("Приступаем к техобслуживанию "+ queue.peek().getBrand()+" "+queue.peek().getModel());
            queue.poll();
            conductService();
        } else {
            System.out.println("Очередь на техобслуживание пуста");
        }
    }
}
