package com.example.nongenerated;

import com.example.generated.StateClassName;
import com.example.generated.Trigger;
import com.github.oxo42.stateless4j.StateMachine;
import com.github.oxo42.stateless4j.StateMachineConfig;
import com.github.oxo42.stateless4j.triggers.TriggerWithParameters1;
import com.github.oxo42.stateless4j.triggers.TriggerWithParameters2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelegateImplTest {

  @Test
  void test() {
    DelegateImpl delegate = new DelegateImpl();

    ClassName<?, ?> className = new ClassName(delegate);
    StateMachineConfig<StateClassName, Trigger> config = className.getConfig();

    StateMachine<StateClassName, Trigger> stateMachine = new StateMachine<>(StateClassName.State1
        , config);

    stateMachine.fire(Trigger.FLY);

    stateMachine.fire(new TriggerWithParameters2<>(Trigger.WALK,
        ParameterizedClass.class,
        Integer.class), new ParameterizedClass("asd", 3.5), 0);

    stateMachine.fire(new TriggerWithParameters1<>(Trigger.JUMP,
        Integer.class), 333);

    assertEquals(StateClassName.State4, stateMachine.getState());
    String expectedHistory = "exit1\n" +
        "exit31\n" +
        "exit32\n" +
        "entry22 asd 3.5 0\n";
    assertEquals(expectedHistory, delegate.currentHistory());
  }
}