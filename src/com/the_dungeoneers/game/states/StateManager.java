package com.the_dungeoneers.game.states;

import java.util.Stack;

/**
 * State Manager
 */
public class StateManager{
	
	private Stack<State> states;
	
	public StateManager(State state){
		states = new Stack<>();
		states.push(state);
	}
	
	public StateManager(){
		states = new Stack<>();
	}
	
	public void startState(State state){
		states.push(state);
	}
	
	public void endState(){
		if (!states.isEmpty()) {
			states.pop();
		}
	}
	
	public State getState(){
		return states.peek();
	}
	
	
}
