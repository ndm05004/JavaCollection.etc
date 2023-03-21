package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Stack의 관련 메소드
		 * 1. 자료를 입력하는 메소드: push(입력값) 
		 * 2. 자료를 출력하는 메소드: pop() => 위에있는 자료를 꺼내고 자료를 stack에서 삭제
		 *                      peek() => 삭제없이 자료를 출력
		 */
		Stack<String> stack = new Stack<>();
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("성춘향");
		stack.push("변학도");
		
		System.out.println("현재 Stack ==> " + stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 값: "+data);
		System.out.println("꺼내온 값: "+stack.pop());
		System.out.println("현재 Stack ==> " + stack);
		
		stack.push("강감찬");
		System.out.println("현재 Stack ==> " + stack);
		System.out.println("꺼내온 값: "+stack.pop());
		System.out.println("현재 Stack ==> " + stack);
		
		System.out.println("삭제없이 꺼내온 값: " + stack.peek());
		System.out.println("현재 Stack ==> " + stack);
		
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println();
		
		/*
		 * QUEUE의 명령
		 * 1. 자료입력: offer(입력값)
		 * 2. 자료출력: poll() ==> 자료를 꺼내오고 자료를 큐에서 삭제
		 *            peek() ==> 삭제없이 자료를 꺼내온다.
		 * queue는 linkedlist를 이용해서 사용할 
 		 */
		
		Queue<String> queue = new LinkedList<>();
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("성춘향");
		queue.offer("변학도");
		
		
		System.out.println("현재 queue =>" + queue);
		String temp = queue.poll();
		
		System.out.println("꺼내온 값: "+ temp);
		System.out.println("꺼내온 값: "+ queue.poll());
		System.out.println("현재 queue =>" + queue);
		
		queue.offer("강감찬");
		System.out.println("현재 queue =>" + queue);
		
		System.out.println(" 꺼내온 값: "+queue.poll());
		
		System.out.println("삭제없이 꺼내온 값" + queue.peek());
		
		
		
	}

}
