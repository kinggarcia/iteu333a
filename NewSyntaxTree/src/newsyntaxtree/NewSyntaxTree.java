package newsyntaxtree;

import java.util.LinkedList;
import java.util.Scanner;
//test
public class NewSyntaxTree {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        String replace;
        int replaceindex;

        LinkedList valhold = new LinkedList();
        LinkedList exp = new LinkedList();

        char[] arr = input.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '*' || arr[i] == '/') {
                exp.addFirst(arr[i]);
                if (arr[i - 1] != '*' && arr[i - 1] != '/' && arr[i - 1] != '+' && arr[i - 1] != '-') {
                    valhold.add(arr[i - 1]);
                    replaceindex = i;
                } else {
                    replaceindex = i + 1;
                }
                if (arr[i + 1] != '*' && arr[i + 1] != '/' && arr[i + 1] != '+' && arr[i + 1] != '-') {
                    valhold.add(arr[i + 1]);
                } else {
                    replaceindex = i + 1;
                }
                try {
                    replace = input.substring(replaceindex - 1, replaceindex + 2);
                } catch (Exception e) {
                    replace = input.substring(replaceindex - 1, replaceindex + 1);
                }
                input = input.replace(replace, "");
                i = 0;
            }
            arr = input.toCharArray();

//          a+b-c*d/0
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '+' || arr[i] == '-') {
                exp.addFirst(arr[i]);
                if (arr[i - 1] != '*' && arr[i - 1] != '/' && arr[i - 1] != '+' && arr[i - 1] != '-') {
                    valhold.add(arr[i - 1]);
                    replaceindex = i;
                } else {
                    replaceindex = i + 1;
                }
                if (arr[i + 1] != '*' && arr[i + 1] != '/' && arr[i + 1] != '+' && arr[i + 1] != '-') {
                    try {
                    if (arr[i + 1] != '*' && arr[i + 1] != '/' && arr[i + 1] != '+' && arr[i + 1] != '-') {
                        valhold.add(arr[i + 1]);
                    }
                    } catch (Exception e) {
                        valhold.removeLast();
                    }
                } else {
                    replaceindex = i + 1;
                }
                try {
                    replace = input.substring(replaceindex - 1, replaceindex + 2);
                } catch (Exception e) {
//                    replace = input.substring(replaceindex - 1, replaceindex + 1);
                      replace = input.substring(replaceindex - 1, replaceindex);
                }
                input = input.replace(replace, "");
                i = 0;

            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '=') {
                input = input.replaceAll("\\s+", "");
                input = input.substring(0, 2);
                arr = input.toCharArray();
                valhold.add(arr[0]);
                exp.addFirst(arr[1]);

            }
        }

        for (int i = 0; i < exp.size(); i++) {
            try {
                System.out.println(exp.get(i));
            } catch (Exception e) {

            }
        }
        for (int i = 0; i < valhold.size(); i++) {
            try {
                System.out.print(valhold.get(i) + " ");
            } catch (Exception e) {

            }
        }

//        System.out.println(valhold);
    }

}
