package bagli_sirala;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bagli_Sirala {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Lutfen dosya adini giriniz: ");
        String dosyaAdi = scan.nextLine();
        scan.close();

        List<Node> nodes = new ArrayList<>();
        List<Node> sortedNodes = new ArrayList<>();
        List<Node> copyNode = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                int data = Integer.parseInt(line);
                nodes.add(new Node(data, index));
                copyNode.add(new Node(data, index));
                index++;
            }

            sortedNodes.addAll(nodes);
            selectionSort(sortedNodes);

            System.out.println("Ilk Hali\t\t\tSon Hali");
            System.out.println("x\ty\t\t\tx\ty");
            for (int i = 0; i < nodes.size(); i++) {
                Node node = nodes.get(i);
                Node copy = copyNode.get(i);
                System.out.println(copy.x + "\t" + copy.y + "\t\t\t" + node.x + "\t" + node.y);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void selectionSort(List<Node> nodes) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nodes.size(); j++) {
                if (nodes.get(j).x < nodes.get(minIndex).x) {
                    minIndex = j;
                }
            }
            int tempAddress = nodes.get(minIndex).y;
            nodes.get(minIndex).y = nodes.get(i).y;
            nodes.get(i).y = tempAddress;

            Node temp = nodes.get(minIndex);
            nodes.set(minIndex, nodes.get(i));
            nodes.set(i, temp);
        }
    }
}

