# 🔥 Top 20 React Interview Questions & Answers

## Core Basics

### 1. What is React and what are its main features?

React is a JavaScript library for building user interfaces, particularly web applications. It was created by Facebook and is now maintained by Meta and the open-source community.

**Main Features:**

-   **Component-Based Architecture**: Build encapsulated components that manage their own state
-   **Virtual DOM**: Efficient rendering through a virtual representation of the DOM
-   **Declarative**: Describe what the UI should look like for any given state
-   **Learn Once, Write Anywhere**: Can be used for web, mobile (React Native), and desktop apps
-   **One-Way Data Flow**: Data flows down from parent to child components
-   **JSX**: JavaScript syntax extension for writing HTML-like code

```jsx
// Simple React component example
import React from 'react';

function Welcome({ name }) {
  return <h1>Hello, {name}!</h1>;
}

export default Welcome;

```

### 2. What are the differences between functional components and class components?

**Functional Components:**

-   Simpler syntax
-   Use React Hooks for state and lifecycle
-   Better performance (slightly)
-   Easier to test and reason about

**Class Components:**

-   More verbose syntax
-   Use `this.state` and lifecycle methods
-   Legacy approach (still supported)

```jsx
// Functional Component
import React, { useState, useEffect } from 'react';

function Counter() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    document.title = `Count: ${count}`;
  }, [count]);

  return (
    <div>
      <p>You clicked {count} times</p>
      <button onClick={() => setCount(count + 1)}>
        Click me
      </button>
    </div>
  );
}

// Class Component (equivalent)
import React, { Component } from 'react';

class Counter extends Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
  }

  componentDidMount() {
    document.title = `Count: ${this.state.count}`;
  }

  componentDidUpdate() {
    document.title = `Count: ${this.state.count}`;
  }

  render() {
    return (
      <div>
        <p>You clicked {this.state.count} times</p>
        <button onClick={() => this.setState({ count: this.state.count + 1 })}>
          Click me
        </button>
      </div>
    );
  }
}

```

### 3. What is JSX and why do we use it?

JSX (JavaScript XML) is a syntax extension for JavaScript that allows you to write HTML-like code within JavaScript. It makes React components more readable and easier to write.

**Benefits of JSX:**

-   More intuitive than `React.createElement()`
-   Easier to visualize the component structure
-   Allows embedding JavaScript expressions
-   Better error messages and warnings

```jsx
// JSX
const element = <h1>Hello, {name}!</h1>;

// Without JSX (equivalent)
const element = React.createElement('h1', null, 'Hello, ', name, '!');

// JSX with expressions
function Greeting({ user }) {
  return (
    <div>
      <h1>Welcome back!</h1>
      {user ? (
        <p>Hello, {user.name}!</p>
      ) : (
        <p>Please sign up.</p>
      )}
    </div>
  );
}

```

### 4. What are props and state in React?

**Props (Properties):**

-   Data passed from parent to child components
-   Read-only (immutable)
-   Used to configure components

**State:**

-   Internal data that belongs to a component
-   Mutable (can be changed)
-   When state changes, component re-renders

```jsx
// Props example
function Welcome({ name, age }) {
  return <h1>Hello {name}, you are {age} years old!</h1>;
}

// Usage
<Welcome name="John" age={25} />

// State example
import React, { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);
  const [message, setMessage] = useState('');

  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>+</button>
      <button onClick={() => setCount(count - 1)}>-</button>
      
      <input 
        value={message}
        onChange={(e) => setMessage(e.target.value)}
        placeholder="Type a message..."
      />
      <p>Message: {message}</p>
    </div>
  );
}

```

### 5. Explain the difference between controlled and uncontrolled components.

**Controlled Components:**

-   Form data is handled by React state
-   React controls the input's value
-   More predictable and easier to validate

**Uncontrolled Components:**

-   Form data is handled by the DOM itself
-   Use refs to access form values
-   Less code but harder to control

```jsx
import React, { useState, useRef } from 'react';

// Controlled Component
function ControlledForm() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Email:', email, 'Password:', password);
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        placeholder="Email"
      />
      <input
        type="password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
        placeholder="Password"
      />
      <button type="submit">Submit</button>
    </form>
  );
}

// Uncontrolled Component
function UncontrolledForm() {
  const emailRef = useRef();
  const passwordRef = useRef();

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Email:', emailRef.current.value);
    console.log('Password:', passwordRef.current.value);
  };

  return (
    <form onSubmit={handleSubmit}>
      <input ref={emailRef} type="email" placeholder="Email" />
      <input ref={passwordRef} type="password" placeholder="Password" />
      <button type="submit">Submit</button>
    </form>
  );
}

```

## React Hooks

### 6. What are React Hooks? Name some commonly used ones.

React Hooks are functions that let you use state and other React features in functional components. They were introduced in React 16.8.

**Commonly Used Hooks:**

-   `useState` - Manage component state
-   `useEffect` - Handle side effects and lifecycle events
-   `useContext` - Access React context
-   `useReducer` - Manage complex state logic
-   `useMemo` - Memoize expensive calculations
-   `useCallback` - Memoize functions
-   `useRef` - Access DOM elements or store mutable values

```jsx
import React, { useState, useEffect, useMemo } from 'react';

function UserProfile({ userId }) {
  const [user, setUser] = useState(null);
  const [posts, setPosts] = useState([]);

  // useEffect for data fetching
  useEffect(() => {
    fetchUser(userId).then(setUser);
    fetchUserPosts(userId).then(setPosts);
  }, [userId]);

  // useMemo for expensive calculation
  const postCount = useMemo(() => {
    return posts.filter(post => post.published).length;
  }, [posts]);

  if (!user) return <div>Loading...</div>;

  return (
    <div>
      <h1>{user.name}</h1>
      <p>Published posts: {postCount}</p>
    </div>
  );
}

```

### 7. What is the difference between `useState` and `useReducer`?

**useState:**

-   Simple state management
-   Good for primitive values or simple objects
-   Direct state updates

**useReducer:**

-   Complex state management
-   Good for objects with multiple sub-values
-   State updates through actions and reducers
-   Similar to Redux pattern

```jsx
import React, { useState, useReducer } from 'react';

// useState example
function SimpleCounter() {
  const [count, setCount] = useState(0);

  return (
    <div>
      <p>{count}</p>
      <button onClick={() => setCount(count + 1)}>+</button>
      <button onClick={() => setCount(count - 1)}>-</button>
    </div>
  );
}

// useReducer example
const initialState = { count: 0, step: 1 };

function reducer(state, action) {
  switch (action.type) {
    case 'increment':
      return { ...state, count: state.count + state.step };
    case 'decrement':
      return { ...state, count: state.count - state.step };
    case 'setStep':
      return { ...state, step: action.step };
    case 'reset':
      return initialState;
    default:
      throw new Error();
  }
}

function ComplexCounter() {
  const [state, dispatch] = useReducer(reducer, initialState);

  return (
    <div>
      <p>Count: {state.count}</p>
      <p>Step: {state.step}</p>
      <button onClick={() => dispatch({ type: 'increment' })}>+</button>
      <button onClick={() => dispatch({ type: 'decrement' })}>-</button>
      <input
        value={state.step}
        onChange={(e) => dispatch({ type: 'setStep', step: Number(e.target.value) })}
      />
      <button onClick={() => dispatch({ type: 'reset' })}>Reset</button>
    </div>
  );
}

```

### 8. How does the `useEffect` hook work, and what are some common use cases?

`useEffect` lets you perform side effects in functional components. It serves the same purpose as `componentDidMount`, `componentDidUpdate`, and `componentWillUnmount` combined.

**Common Use Cases:**

-   Data fetching
-   Setting up subscriptions
-   Manually changing the DOM
-   Cleanup (removing event listeners, canceling network requests)

```jsx
import React, { useState, useEffect } from 'react';

function UserList() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);

  // Effect with dependency array
  useEffect(() => {
    let cancelled = false;

    const fetchUsers = async () => {
      try {
        setLoading(true);
        const response = await fetch('/api/users');
        const data = await response.json();
        
        if (!cancelled) {
          setUsers(data);
        }
      } catch (error) {
        if (!cancelled) {
          console.error('Error fetching users:', error);
        }
      } finally {
        if (!cancelled) {
          setLoading(false);
        }
      }
    };

    fetchUsers();

    // Cleanup function
    return () => {
      cancelled = true;
    };
  }, []); // Empty dependency array - runs once

  // Effect for document title
  useEffect(() => {
    document.title = `Users (${users.length})`;
  }, [users.length]); // Runs when users.length changes

  // Effect with cleanup
  useEffect(() => {
    const handleResize = () => {
      console.log('Window resized');
    };

    window.addEventListener('resize', handleResize);

    return () => {
      window.removeEventListener('resize', handleResize);
    };
  }, []); // No dependencies - runs once

  if (loading) return <div>Loading...</div>;

  return (
    <ul>
      {users.map(user => (
        <li key={user.id}>{user.name}</li>
      ))}
    </ul>
  );
}

```

### 9. What is the difference between `useMemo` and `useCallback`?

Both hooks are used for performance optimization through memoization, but they memoize different things:

**useMemo:**

-   Memoizes the result of a function
-   Prevents expensive calculations on every render
-   Returns a value

**useCallback:**

-   Memoizes the function itself
-   Prevents function recreation on every render
-   Returns a function

```jsx
import React, { useState, useMemo, useCallback } from 'react';

function ExpensiveComponent({ items, onItemClick }) {
  const [filter, setFilter] = useState('');
  const [sortOrder, setSortOrder] = useState('asc');

  // useMemo - memoizes the computed value
  const filteredAndSortedItems = useMemo(() => {
    console.log('Filtering and sorting items...');
    
    let filtered = items.filter(item => 
      item.name.toLowerCase().includes(filter.toLowerCase())
    );
    
    return filtered.sort((a, b) => {
      if (sortOrder === 'asc') {
        return a.name.localeCompare(b.name);
      } else {
        return b.name.localeCompare(a.name);
      }
    });
  }, [items, filter, sortOrder]); // Recalculates when dependencies change

  // useCallback - memoizes the function
  const handleItemClick = useCallback((item) => {
    console.log('Item clicked:', item);
    onItemClick(item);
  }, [onItemClick]); // Function is recreated only when onItemClick changes

  const handleSortToggle = useCallback(() => {
    setSortOrder(prev => prev === 'asc' ? 'desc' : 'asc');
  }, []); // Function never changes

  return (
    <div>
      <input
        value={filter}
        onChange={(e) => setFilter(e.target.value)}
        placeholder="Filter items..."
      />
      <button onClick={handleSortToggle}>
        Sort {sortOrder === 'asc' ? '↑' : '↓'}
      </button>
      
      <ul>
        {filteredAndSortedItems.map(item => (
          <li key={item.id}>
            <button onClick={() => handleItemClick(item)}>
              {item.name}
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

// Child component that benefits from useCallback
const ItemButton = React.memo(({ item, onClick }) => {
  console.log('ItemButton rendered for:', item.name);
  
  return (
    <button onClick={() => onClick(item)}>
      {item.name}
    </button>
  );
});

```

### 10. How does `useRef` work in React? Give an example.

`useRef` returns a mutable ref object whose `.current` property is initialized to the passed argument. It's useful for:

-   Accessing DOM elements directly
-   Storing mutable values that don't cause re-renders
-   Keeping references to previous values

```jsx
import React, { useRef, useState, useEffect } from 'react';

function RefExamples() {
  // 1. DOM element reference
  const inputRef = useRef(null);
  const [inputValue, setInputValue] = useState('');

  // 2. Storing previous value
  const prevCountRef = useRef();
  const [count, setCount] = useState(0);

  // 3. Storing mutable value
  const renderCountRef = useRef(0);

  // 4. Timer reference
  const timerRef = useRef(null);
  const [seconds, setSeconds] = useState(0);

  useEffect(() => {
    // Update render count
    renderCountRef.current += 1;
    
    // Store previous count
    prevCountRef.current = count;
  });

  const focusInput = () => {
    inputRef.current.focus();
  };

  const startTimer = () => {
    if (timerRef.current) return;
    
    timerRef.current = setInterval(() => {
      setSeconds(prev => prev + 1);
    }, 1000);
  };

  const stopTimer = () => {
    if (timerRef.current) {
      clearInterval(timerRef.current);
      timerRef.current = null;
    }
  };

  const resetTimer = () => {
    stopTimer();
    setSeconds(0);
  };

  useEffect(() => {
    // Cleanup timer on unmount
    return () => stopTimer();
  }, []);

  return (
    <div>
      <h3>useRef Examples</h3>
      
      {/* 1. DOM Reference */}
      <div>
        <input
          ref={inputRef}
          value={inputValue}
          onChange={(e) => setInputValue(e.target.value)}
          placeholder="Click button to focus"
        />
        <button onClick={focusInput}>Focus Input</button>
      </div>

      {/* 2. Previous Value */}
      <div>
        <p>Current count: {count}</p>
        <p>Previous count: {prevCountRef.current}</p>
        <button onClick={() => setCount(count + 1)}>Increment</button>
      </div>

      {/* 3. Render Count */}
      <div>
        <p>Component rendered {renderCountRef.current} times</p>
      </div>

      {/* 4. Timer */}
      <div>
        <p>Timer: {seconds} seconds</p>
        <button onClick={startTimer}>Start</button>
        <button onClick={stopTimer}>Stop</button>
        <button onClick={resetTimer}>Reset</button>
      </div>
    </div>
  );
}

export default RefExamples;

```

## Lifecycle & Rendering

### 11. Explain the React component lifecycle methods (in class components) and how they compare to Hooks.

**Class Component Lifecycle Methods:**

**Mounting:**

-   `constructor()` - Initialize state
-   `componentDidMount()` - After component mounts

**Updating:**

-   `componentDidUpdate()` - After component updates
-   `getSnapshotBeforeUpdate()` - Before DOM updates

**Unmounting:**

-   `componentWillUnmount()` - Before component unmounts

**Hook Equivalents:**

```jsx
import React, { useState, useEffect, useLayoutEffect } from 'react';

// Class Component
class LifecycleClass extends React.Component {
  constructor(props) {
    super(props);
    this.state = { count: 0, data: null };
    console.log('Constructor');
  }

  componentDidMount() {
    console.log('Component did mount');
    this.fetchData();
  }

  componentDidUpdate(prevProps, prevState) {
    console.log('Component did update');
    if (prevProps.userId !== this.props.userId) {
      this.fetchData();
    }
  }

  componentWillUnmount() {
    console.log('Component will unmount');
    this.cleanup();
  }

  fetchData = () => {
    // Fetch data logic
  };

  cleanup = () => {
    // Cleanup logic
  };

  render() {
    return <div>Count: {this.state.count}</div>;
  }
}

// Functional Component with Hooks
function LifecycleHooks({ userId }) {
  const [count, setCount] = useState(0); // Constructor equivalent
  const [data, setData] = useState(null);

  // componentDidMount equivalent
  useEffect(() => {
    console.log('Component mounted');
    fetchData();

    // componentWillUnmount equivalent
    return () => {
      console.log('Component will unmount');
      cleanup();
    };
  }, []); // Empty dependency array = runs once

  // componentDidUpdate equivalent
  useEffect(() => {
    console.log('userId changed');
    fetchData();
  }, [userId]); // Runs when userId changes

  // componentDidUpdate for any change
  useEffect(() => {
    console.log('Component updated');
  }); // No dependency array = runs after every render

  const fetchData = () => {
    // Fetch data logic
  };

  const cleanup = () => {
    // Cleanup logic
  };

  return <div>Count: {count}</div>;
}

```

### 12. What is reconciliation in React and how does the Virtual DOM work?

**Reconciliation** is the process by which React updates the DOM. When state changes, React needs to figure out how to efficiently update the UI.

**Virtual DOM Process:**

1.  React creates a virtual representation of the DOM in memory
2.  When state changes, React creates a new virtual DOM tree
3.  React compares (diffs) the new tree with the previous tree
4.  React calculates the minimum changes needed
5.  React updates only the changed parts in the real DOM

```jsx
import React, { useState } from 'react';

function ReconciliationExample() {
  const [items, setItems] = useState([
    { id: 1, name: 'Apple', done: false },
    { id: 2, name: 'Banana', done: true },
    { id: 3, name: 'Cherry', done: false }
  ]);

  const toggleItem = (id) => {
    setItems(items.map(item => 
      item.id === id 
        ? { ...item, done: !item.done }
        : item
    ));
  };

  const addItem = () => {
    const newItem = {
      id: Date.now(),
      name: `Item ${items.length + 1}`,
      done: false
    };
    setItems([...items, newItem]);
  };

  return (
    <div>
      <h3>Todo List (Reconciliation Demo)</h3>
      <button onClick={addItem}>Add Item</button>
      
      <ul>
        {items.map(item => (
          <li 
            key={item.id} // Important for reconciliation!
            style={{ 
              textDecoration: item.done ? 'line-through' : 'none',
              color: item.done ? 'gray' : 'black'
            }}
            onClick={() => toggleItem(item.id)}
          >
            {item.name}
          </li>
        ))}
      </ul>
    </div>
  );
}

// Bad example - no keys (React will re-render all items)
function BadReconciliation() {
  const [items, setItems] = useState(['Apple', 'Banana', 'Cherry']);
  
  return (
    <ul>
      {items.map((item, index) => (
        <li>{item}</li> // No key!
      ))}
    </ul>
  );
}

// Good example - with keys (React can efficiently update)
function GoodReconciliation() {
  const [items, setItems] = useState([
    { id: 'apple', name: 'Apple' },
    { id: 'banana', name: 'Banana' },
    { id: 'cherry', name: 'Cherry' }
  ]);
  
  return (
    <ul>
      {items.map(item => (
        <li key={item.id}>{item.name}</li> // With key!
      ))}
    </ul>
  );
}

```

### 13. How does React handle re-rendering, and how can you optimize performance?

React re-renders components when:

-   State changes
-   Props change
-   Parent component re-renders

**Performance Optimization Techniques:**

```jsx
import React, { useState, useMemo, useCallback, memo } from 'react';

// 1. React.memo - Prevents unnecessary re-renders
const ExpensiveChild = memo(({ data, onUpdate }) => {
  console.log('ExpensiveChild rendered');
  
  return (
    <div>
      <p>Data: {data.value}</p>
      <button onClick={() => onUpdate(data.id)}>Update</button>
    </div>
  );
});

// 2. useMemo - Memoize expensive calculations
function OptimizedParent() {
  const [count, setCount] = useState(0);
  const [items, setItems] = useState([
    { id: 1, value: 'A', category: 'letters' },
    { id: 2, value: 'B', category: 'letters' },
    { id: 3, value: '1', category: 'numbers' },
    { id: 4, value: '2', category: 'numbers' }
  ]);
  const [filter, setFilter] = useState('all');

  // Memoized expensive calculation
  const filteredItems = useMemo(() => {
    console.log('Filtering items...');
    return items.filter(item => 
      filter === 'all' || item.category === filter
    );
  }, [items, filter]);

  // Memoized callback
  const handleUpdate = useCallback((id) => {
    setItems(current => 
      current.map(item => 
        item.id === id 
          ? { ...item, value: item.value + '!' }
          : item
      )
    );
  }, []);

  return (
    <div>
      <h3>Performance Optimization Example</h3>
      
      <div>
        <p>Count: {count}</p>
        <button onClick={() => setCount(count + 1)}>
          Increment Count
        </button>
      </div>

      <div>
        <label>
          Filter: 
          <select value={filter} onChange={(e) => setFilter(e.target.value)}>
            <option value="all">All</option>
            <option value="letters">Letters</option>
            <option value="numbers">Numbers</option>
          </select>
        </label>
      </div>

      <div>
        {filteredItems.map(item => (
          <ExpensiveChild 
            key={item.id}
            data={item}
            onUpdate={handleUpdate}
          />
        ))}
      </div>
    </div>
  );
}

// 3. Splitting components to minimize re-renders
function SplitComponents() {
  return (
    <div>
      <Header /> {/* Won't re-render when counter changes */}
      <Counter />
      <Footer /> {/* Won't re-render when counter changes */}
    </div>
  );
}

function Header() {
  console.log('Header rendered');
  return <h1>My App</h1>;
}

function Counter() {
  const [count, setCount] = useState(0);
  console.log('Counter rendered');
  
  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>+</button>
    </div>
  );
}

function Footer() {
  console.log('Footer rendered');
  return <footer>© 2023 My App</footer>;
}

export default OptimizedParent;

```

### 14. What are keys in React lists, and why are they important?

Keys help React identify which list items have changed, been added, or removed. They are crucial for efficient reconciliation and maintaining component state.

```jsx
import React, { useState } from 'react';

function KeysExample() {
  const [users, setUsers] = useState([
    { id: 1, name: 'Alice', email: 'alice@example.com' },
    { id: 2, name: 'Bob', email: 'bob@example.com' },
    { id: 3, name: 'Charlie', email: 'charlie@example.com' }
  ]);
  const [nextId, setNextId] = useState(4);

  const addUser = () => {
    const newUser = {
      id: nextId,
      name: `User ${nextId}`,
      email: `user${nextId}@example.com`
    };
    setUsers([newUser, ...users]); // Add to beginning
    setNextId(nextId + 1);
  };

  const removeUser = (id) => {
    setUsers(users.filter(user => user.id !== id));
  };

  const shuffleUsers = () => {
    const shuffled = [...users];
    for (let i = shuffled.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [shuffled[i], shuffled[j]] = [shuffled[j], shuffled[i]];
    }
    setUsers(shuffled);
  };

  return (
    <div>
      <h3>Keys in Lists Example</h3>
      
      <div>
        <button onClick={addUser}>Add User (to top)</button>
        <button onClick={shuffleUsers}>Shuffle Users</button>
      </div>

      <h4>Good Example - With Keys:</h4>
      <div>
        {users.map(user => (
          <UserCard
            key={user.id} // Unique, stable key
            user={user}
            onRemove={removeUser}
          />
        ))}
      </div>

      <h4>Bad Example - With Index as Key:</h4>
      <div>
        {users.map((user, index) => (
          <UserCard
            key={index} // DON'T do this!
            user={user}
            onRemove={removeUser}
          />
        ))}
      </div>

      <h4>Terrible Example - No Keys:</h4>
      <div>
        {users.map(user => (
          <UserCard // No key at all!
            user={user}
            onRemove={removeUser}
          />
        ))}
      </div>
    </div>
  );
}

function UserCard({ user, onRemove }) {
  const [isEditing, setIsEditing] = useState(false);
  const [editName, setEditName] = useState(user.name);

  console.log(`UserCard rendered for ${user.name}`);

  const handleSave = () => {
    // In real app, you'd update the user
    setIsEditing(false);
  };

  return (
    <div style={{ 
      border: '1px solid #ccc', 
      margin: '5px', 
      padding: '10px',
      backgroundColor: isEditing ? '#f0f8ff' : 'white'
    }}>
      {isEditing ? (
        <div>
          <input
            value={editName}
            onChange={(e) => setEditName(e.target.value)}
            autoFocus
          />
          <button onClick={handleSave}>Save</button>
          <button onClick={() => setIsEditing(false)}>Cancel</button>
        </div>
      ) : (
        <div>
          <h4>{user.name}</h4>
          <p>{user.email}</p>
          <button onClick={() => setIsEditing(true)}>Edit</button>
          <button onClick={() => onRemove(user.id)}>Remove</button>
        </div>
      )}
    </div>
  );
}

export default KeysExample;

```

## Advanced Concepts

### 15. What is Context API, and how is it different from Redux?

Context API allows you to pass data through the component tree without having to pass props down manually at every level.

**Context API vs Redux:**

-   **Context API**: Built into React, simpler for small to medium apps
-   **Redux**: Third-party library, better for complex state management, time-travel debugging

```jsx
import React, { createContext, useContext, useReducer } from 'react';

// 1. Create Context
const ThemeContext = createContext();
const UserContext = createContext();

// 2. Theme Provider
function ThemeProvider({ children }) {
  const [theme, setTheme] = useState('light');
  
  const toggleTheme = () => {
    setTheme(prev => prev === 'light' ? 'dark' : 'light');
  };

  const value = {
    theme,
    toggleTheme
  };

  return (
    <ThemeContext.Provider value={value}>
      {children}
    </ThemeContext.Provider>
  );
}

// 3. User Context with useReducer
const userInitialState = {
  user: null,
  loading: false,
  error: null
};

function userReducer(state, action) {
  switch (action.type) {
    case 'LOGIN_START':
      return { ...state, loading: true, error: null };
    case 'LOGIN_SUCCESS':
      return { ...state, loading: false, user: action.user };
    case 'LOGIN_ERROR':
      return { ...state, loading: false, error: action.error };
    case 'LOGOUT':
      return { ...state, user: null };
    default:
      return state;
  }
}

function UserProvider({ children }) {
  const [state, dispatch] = useReducer(userReducer, userInitialState);

  const login = async (credentials) => {
    dispatch({ type: 'LOGIN_START' });
    try {
      const user = await authenticateUser(credentials);
      dispatch({ type: 'LOGIN_SUCCESS', user });
    } catch (error) {
      dispatch({ type: 'LOGIN_ERROR', error: error.message });
    }
  };

  const logout = () => {
    dispatch({ type: 'LOGOUT' });
  };

  const value = {
    ...state,
    login,
    logout
  };

  return (
    <UserContext.Provider value={value}>
      {children}
    </UserContext.Provider>
  );
}

// 4. Custom hooks for consuming context
function useTheme() {
  const context = useContext(ThemeContext);
  if (!context) {
    throw new Error('useTheme must be used within a ThemeProvider');
  }
  return context;
}

function useUser() {
  const context = useContext(UserContext);
  if (!context) {
    throw new Error('useUser must be used within a UserProvider');
  }
  return context;
}

// 5. Components using context
function App() {
  return (
    <ThemeProvider>
      <UserProvider>
        <Header />
        <MainContent />
      </UserProvider>
    </ThemeProvider>
  );
}

function Header() {
  const { theme, toggleTheme } = useTheme();
  const { user, logout } = useUser();

  return (
    <header style={{ 
      background: theme === 'light' ? '#fff' : '#333',
      color: theme === 'light' ? '#333' : '#fff'
    }}>
      <h1>My App</h1>
      <button onClick={toggleTheme}>
        Switch to {theme === 'light' ? 'dark' : 'light'} theme
      </button>
      {user ? (
        <div>
          Welcome, {user.name}!
          <button onClick={logout}>Logout</button>
        </div>
      ) : (
        <LoginForm />
      )}
    </header>
  );
}

function LoginForm() {
  const { login, loading, error } = useUser();
  const [credentials, setCredentials] = useState({ email: '', password: '' });

  const handleSubmit = (e) => {
    e.preventDefault();
    login(credentials);
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="email"
        value={credentials.email}
        onChange={(e) => setCredentials({ ...credentials, email: e.target.value })}
        placeholder="Email"
      />
      <input
        type="password"
        value={credentials.password}
        onChange={(e) => setCredentials({ ...credentials, password: e.target.value })}
        placeholder="Password"
      />
      <button type="submit" disabled={loading}>
        {loading ? 'Logging in...' : 'Login'}
      </button>
      {error && <p style={{ color: 'red' }}>{error}</p>}
    </form>
  );
}

// Mock authentication function
async function authenticateUser(credentials) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      if (credentials.email === 'test@example.com' && credentials.password === 'password') {
        resolve({ id: 1, name: 'John Doe', email: 'test@example.com' });
      } else {
        reject(new Error('Invalid credentials'));
      }
    }, 1000);
  });
}

```

### 16. What is React Fiber, and how does it improve performance?

React Fiber is a complete rewrite of React's reconciliation algorithm, introduced in React 16. It enables:

**Key Improvements:**

-   **Incremental Rendering**: Break work into chunks
-   **Ability to Pause and Resume**: Work can be paused for higher priority tasks
-   **Priority-based Updates**: Different types of updates have different priorities
-   **Better Error Handling**: Error boundaries
-   **Time Slicing**: Spread work across multiple frames

```jsx
import React, { useState, useTransition, useDeferredValue } from 'react';

// React 18 features that leverage Fiber
function FiberExample() {
  const [inputValue, setInputValue] = useState('');
  const [list, setList] = useState([]);
  const [isPending, startTransition] = useTransition();

  // useDeferredValue for deferring expensive updates
  const deferredInputValue = useDeferredValue(inputValue);

  // Generate expensive list based on deferred value
  const expensiveList = useMemo(() => {
    const items = [];
    for (let i = 0; i < 10000; i++) {
      if (deferredInputValue === '' || 
          `Item ${i}`.toLowerCase().includes(deferredInputValue.toLowerCase())) {
        items.push(`Item ${i}`);
      }
    }
    return items.slice(0, 100); // Limit display
  }, [deferredInputValue]);

  const handleInputChange = (e) => {
    const value = e.target.value;
    setInputValue(value);
    
    // Use transition for non-urgent updates
    startTransition(() => {
      // This update has lower priority
      generateLargeList(value);
    });
  };

  const generateLargeList = (filter) => {
    const newList = [];
    for (let i = 0; i < 5000; i++) {
      if (filter === '' || `Generated ${i}`.includes(filter)) {
        newList.push(`Generated ${i}`);
      }
    }
    setList(newList.slice(0, 50));
  };

  return (
    <div>
      <h3>React Fiber Features Demo</h3>
      
      <div>
        <input
          value={inputValue}
          onChange={handleInputChange}
          placeholder="Type to filter..."
          style={{ fontSize: '16px', padding: '8px' }}
        />
        {isPending && <span> (Updating...)</span>}
      </div>

      <div style={{ display: 'flex', gap: '20px' }}>
        <div>
          <h4>Deferred List (useDeferredValue)</h4>
          <ul style={{ maxHeight: '200px', overflowY: 'scroll' }}>
            {expensiveList.map(item => (
              <li key={item}>{item}</li>
            ))}
          </ul>
        </div>

        <div>
          <h4>Transition List (useTransition)</h4>
          <ul style={{ maxHeight: '200px', overflowY: 'scroll' }}>
            {list.map(item => (
              <li key={item}>{item}</li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
}

// Error Boundary (another Fiber feature)
class ErrorBoundary extends React.Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false, error: null };
  }

  static getDerivedStateFromError(error) {
    return { hasError: true, error };
  }

  componentDidCatch(error, errorInfo) {
    console.log('Error caught by boundary:', error, errorInfo);
  }

  render() {
    if (this.state.hasError) {
      return (
        <div style={{ padding: '20px', border: '1px solid red' }}>
          <h2>Something went wrong.</h2>
          <details>
            <summary>Error details</summary>
            <pre>{this.state.error?.toString()}</pre>
          </details>
          <button onClick={() => this.setState({ hasError: false, error: null })}>
            Try again
          </button>
        </div>
      );
    }

    return this.props.children;
  }
}

// Component that might throw an error
function ProblematicComponent({ shouldError }) {
  if (shouldError) {
    throw new Error('This is a test error!');
  }
  
  return <div>Everything is working fine!</div>;
}

function ErrorBoundaryExample() {
  const [shouldError, setShouldError] = useState(false);

  return (
    <div>
      <h3>Error Boundary Demo</h3>
      <button onClick={() => setShouldError(!shouldError)}>
        {shouldError ? 'Fix Component' : 'Break Component'}
      </button>
      
      <ErrorBoundary>
        <ProblematicComponent shouldError={shouldError} />
      </ErrorBoundary>
    </div>
  );
}

```

### 17. Explain higher-order components (HOCs) and their use cases.

HOCs are functions that take a component and return a new component with additional functionality. They're a pattern for reusing component logic.

```jsx
import React, { useState, useEffect } from 'react';

// 1. Basic HOC - withLoading
function withLoading(WrappedComponent, loadingMessage = 'Loading...') {
  return function LoadingComponent(props) {
    if (props.isLoading) {
      return <div>{loadingMessage}</div>;
    }
    return <WrappedComponent {...props} />;
  };
}

// 2. HOC for authentication
function withAuth(WrappedComponent) {
  return function AuthenticatedComponent(props) {
    const [user, setUser] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
      // Check authentication status
      const token = localStorage.getItem('authToken');
      if (token) {
        // Verify token and get user
        fetchUser(token).then(user => {
          setUser(user);
          setLoading(false);
        });
      } else {
        setLoading(false);
      }
    }, []);

    if (loading) {
      return <div>Checking authentication...</div>;
    }

    if (!user) {
      return <div>Please log in to access this page.</div>;
    }

    return <WrappedComponent {...props} user={user} />;
  };
}

// 3. HOC for data fetching
function withData(WrappedComponent, fetchData) {
  return function DataComponent(props) {
    const [data, setData] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
      let cancelled = false;

      const loadData = async () => {
        try {
          setLoading(true);
          setError(null);
          const result = await fetchData(props);
          if (!cancelled) {
            setData(result);
          }
        } catch (err) {
          if (!cancelled) {
            setError(err.message);
          }
        } finally {
          if (!cancelled) {
            setLoading(false);
          }
        }
      };

      loadData();

      return () => {
        cancelled = true;
      };
    }, [props.id]); // Re-fetch when id changes

    const enhancedProps = {
      ...props,
      data,
      loading,
      error,
      refetch: () => {
        setData(null);
        setLoading(true);
        setError(null);
        loadData();
      }
    };

    return <WrappedComponent {...enhancedProps} />;
  };
}

// 4. HOC for performance monitoring
function withPerformanceMonitoring(WrappedComponent) {
  return function MonitoredComponent(props) {
    const componentName = WrappedComponent.displayName || WrappedComponent.name;
    
    useEffect(() => {
      const startTime = performance.now();
      
      return () => {
        const endTime = performance.now();
        console.log(`${componentName} was mounted for ${endTime - startTime} milliseconds`);
      };
    }, []);

    useEffect(() => {
      console.log(`${componentName} rendered with props:`, props);
    });

    return <WrappedComponent {...props} />;
  };
}

// Base components
function UserProfile({ user, loading, error }) {
  if (error) return <div>Error: {error}</div>;
  if (loading) return <div>Loading profile...</div>;
  
  return (
    <div>
      <h2>{user.name}</h2>
      <p>Email: {user.email}</p>
      <p>Role: {user.role}</p>
    </div>
  );
}

function UserList({ data: users, loading, error, refetch }) {
  if (error) return <div>Error: {error} <button onClick={refetch}>Retry</button></div>;
  if (loading) return <div>Loading users...</div>;
  
  return (
    <div>
      <h2>Users</h2>
      <button onClick={refetch}>Refresh</button>
      <ul>
        {users.map(user => (
          <li key={user.id}>{user.name} ({user.email})</li>
        ))}
      </ul>
    </div>
  );
}

// Apply HOCs
const AuthenticatedUserProfile = withAuth(
  withPerformanceMonitoring(
    withLoading(UserProfile)
  )
);

const UserListWithData = withData(
  withPerformanceMonitoring(UserList), 
  async () => {
    // Mock API call
    const response = await fetch('/api/users');
    return response.json();
  }
);

// Usage
function App() {
  return (
    <div>
      <h1>HOC Examples</h1>
      <AuthenticatedUserProfile />
      <UserListWithData />
    </div>
  );
}

// Modern alternative using custom hooks
function useAuth() {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const token = localStorage.getItem('authToken');
    if (token) {
      fetchUser(token).then(user => {
        setUser(user);
        setLoading(false);
      });
    } else {
      setLoading(false);
    }
  }, []);

  return { user, loading };
}

function useData(fetchData, dependencies = []) {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const refetch = useCallback(async () => {
    try {
      setLoading(true);
      setError(null);
      const result = await fetchData();
      setData(result);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  }, dependencies);

  useEffect(() => {
    refetch();
  }, [refetch]);

  return { data, loading, error, refetch };
}

// Modern component using hooks instead of HOCs
function ModernUserList() {
  const { user, loading: authLoading } = useAuth();
  const { data: users, loading, error, refetch } = useData(
    () => fetch('/api/users').then(r => r.json())
  );

  if (authLoading) return <div>Checking authentication...</div>;
  if (!user) return <div>Please log in.</div>;
  if (error) return <div>Error: {error} <button onClick={refetch}>Retry</button></div>;
  if (loading) return <div>Loading users...</div>;

  return (
    <div>
      <h2>Users (Modern Hooks Version)</h2>
      <button onClick={refetch}>Refresh</button>
      <ul>
        {users.map(user => (
          <li key={user.id}>{user.name} ({user.email})</li>
        ))}
      </ul>
    </div>
  );
}

// Mock functions
async function fetchUser(token) {
  return { id: 1, name: 'John Doe', email: 'john@example.com', role: 'admin' };
}

export default App;

```

### 18. What are React portals, and when would you use them?

React Portals provide a way to render children into a DOM node that exists outside the DOM hierarchy of the parent component.

```jsx
import React, { useState, useEffect } from 'react';
import { createPortal } from 'react-dom';

// 1. Modal Portal
function Modal({ isOpen, onClose, children }) {
  const [modalRoot, setModalRoot] = useState(null);

  useEffect(() => {
    // Create or get modal root element
    let root = document.getElementById('modal-root');
    if (!root) {
      root = document.createElement('div');
      root.id = 'modal-root';
      document.body.appendChild(root);
    }
    setModalRoot(root);

    // Cleanup on unmount
    return () => {
      if (root && root.childElementCount === 0) {
        document.body.removeChild(root);
      }
    };
  }, []);

  useEffect(() => {
    // Prevent body scroll when modal is open
    if (isOpen) {
      document.body.style.overflow = 'hidden';
    } else {
      document.body.style.overflow = 'unset';
    }

    return () => {
      document.body.style.overflow = 'unset';
    };
  }, [isOpen]);

  useEffect(() => {
    // Close on Escape key
    const handleEscape = (e) => {
      if (e.key === 'Escape') {
        onClose();
      }
    };

    if (isOpen) {
      document.addEventListener('keydown', handleEscape);
      return () => document.removeEventListener('keydown', handleEscape);
    }
  }, [isOpen, onClose]);

  if (!isOpen || !modalRoot) return null;

  return createPortal(
    <div 
      className="modal-overlay"
      style={{
        position: 'fixed',
        top: 0,
        left: 0,
        right: 0,
        bottom: 0,
        backgroundColor: 'rgba(0, 0, 0, 0.5)',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        zIndex: 1000
      }}
      onClick={(e) => {
        if (e.target === e.currentTarget) {
          onClose();
        }
      }}
    >
      <div 
        className="modal-content"
        style={{
          backgroundColor: 'white',
          borderRadius: '8px',
          padding: '20px',
          maxWidth: '500px',
          maxHeight: '80vh',
          overflow: 'auto',
          position: 'relative'
        }}
      >
        <button
          onClick={onClose}
          style={{
            position: 'absolute',
            top: '10px',
            right: '10px',
            background: 'none',
            border: 'none',
            fontSize: '20px',
            cursor: 'pointer'
          }}
        >
          ×
        </button>
        {children}
      </div>
    </div>,
    modalRoot
  );
}

// 2. Tooltip Portal
function Tooltip({ children, content, position = 'top' }) {
  const [isVisible, setIsVisible] = useState(false);
  const [coords, setCoords] = useState({ x: 0, y: 0 });
  const [tooltipRoot, setTooltipRoot] = useState(null);

  useEffect(() => {
    let root = document.getElementById('tooltip-root');
    if (!root) {
      root = document.createElement('div');
      root.id = 'tooltip-root';
      document.body.appendChild(root);
    }
    setTooltipRoot(root);
  }, []);

  const handleMouseEnter = (e) => {
    const rect = e.target.getBoundingClientRect();
    setCoords({
      x: rect.left + rect.width / 2,
      y: rect.top
    });
    setIsVisible(true);
  };

  const handleMouseLeave = () => {
    setIsVisible(false);
  };

  const getTooltipStyle = () => {
    const baseStyle = {
      position: 'fixed',
      backgroundColor: '#333',
      color: 'white',
      padding: '8px 12px',
      borderRadius: '4px',
      fontSize: '14px',
      pointerEvents: 'none',
      zIndex: 1001,
      transform: 'translateX(-50%)',
      whiteSpace: 'nowrap'
    };

    switch (position) {
      case 'top':
        return {
          ...baseStyle,
          left: coords.x,
          top: coords.y - 10,
          transform: 'translateX(-50%) translateY(-100%)'
        };
      case 'bottom':
        return {
          ...baseStyle,
          left: coords.x,
          top: coords.y + 10,
          transform: 'translateX(-50%)'
        };
      default:
        return baseStyle;
    }
  };

  return (
    <>
      <span
        onMouseEnter={handleMouseEnter}
        onMouseLeave={handleMouseLeave}
        style={{ cursor: 'help' }}
      >
        {children}
      </span>
      
      {isVisible && tooltipRoot && createPortal(
        <div style={getTooltipStyle()}>
          {content}
        </div>,
        tooltipRoot
      )}
    </>
  );
}

// 3. Notification Portal
function NotificationProvider({ children }) {
  const [notifications, setNotifications] = useState([]);
  const [notificationRoot, setNotificationRoot] = useState(null);

  useEffect(() => {
    let root = document.getElementById('notification-root');
    if (!root) {
      root = document.createElement('div');
      root.id = 'notification-root';
      document.body.appendChild(root);
    }
    setNotificationRoot(root);
  }, []);

  const addNotification = (message, type = 'info', duration = 5000) => {
    const id = Date.now();
    const notification = { id, message, type };
    
    setNotifications(prev => [...prev, notification]);

    if (duration > 0) {
      setTimeout(() => {
        removeNotification(id);
      }, duration);
    }

    return id;
  };

  const removeNotification = (id) => {
    setNotifications(prev => prev.filter(n => n.id !== id));
  };

  const contextValue = {
    addNotification,
    removeNotification
  };

  return (
    <NotificationContext.Provider value={contextValue}>
      {children}
      {notificationRoot && createPortal(
        <div style={{
          position: 'fixed',
          top: '20px',
          right: '20px',
          zIndex: 1002
        }}>
          {notifications.map(notification => (
            <Notification
              key={notification.id}
              notification={notification}
              onClose={() => removeNotification(notification.id)}
            />
          ))}
        </div>,
        notificationRoot
      )}
    </NotificationContext.Provider>
  );
}

function Notification({ notification, onClose }) {
  const getBackgroundColor = () => {
    switch (notification.type) {
      case 'success': return '#4CAF50';
      case 'error': return '#F44336';
      case 'warning': return '#FF9800';
      default: return '#2196F3';
    }
  };

  return (
    <div style={{
      backgroundColor: getBackgroundColor(),
      color: 'white',
      padding: '12px 16px',
      margin: '8px 0',
      borderRadius: '4px',
      boxShadow: '0 2px 8px rgba(0,0,0,0.2)',
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'space-between',
      minWidth: '300px'
    }}>
      <span>{notification.message}</span>
      <button
        onClick={onClose}
        style={{
          background: 'none',
          border: 'none',
          color: 'white',
          cursor: 'pointer',
          marginLeft: '10px'
        }}
      >
        ×
      </button>
    </div>
  );
}

const NotificationContext = React.createContext();

function useNotifications() {
  const context = useContext(NotificationContext);
  if (!context) {
    throw new Error('useNotifications must be used within NotificationProvider');
  }
  return context;
}

// Example usage
function PortalExample() {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const { addNotification } = useNotifications();

  const showSuccessNotification = () => {
    addNotification('Success! Operation completed.', 'success');
  };

  const showErrorNotification = () => {
    addNotification('Error! Something went wrong.', 'error');
  };

  return (
    <div style={{ padding: '20px' }}>
      <h3>React Portals Examples</h3>
      
      <div style={{ marginBottom: '20px' }}>
        <button onClick={() => setIsModalOpen(true)}>
          Open Modal
        </button>
        
        <Modal isOpen={isModalOpen} onClose={() => setIsModalOpen(false)}>
          <h2>Modal Title</h2>
          <p>This modal is rendered using a React Portal!</p>
          <p>It's rendered outside the normal component tree but behaves like a normal React component.</p>
          <button onClick={() => setIsModalOpen(false)}>
            Close Modal
          </button>
        </Modal>
      </div>

      <div style={{ marginBottom: '20px' }}>
        <Tooltip content="This is a helpful tooltip!">
          <span style={{ textDecoration: 'underline' }}>
            Hover over me for tooltip
          </span>
        </Tooltip>
      </div>

      <div>
        <button onClick={showSuccessNotification}>
          Show Success Notification
        </button>
        <button onClick={showErrorNotification} style={{ marginLeft: '10px' }}>
          Show Error Notification
        </button>
      </div>
    </div>
  );
}

function App() {
  return (
    <NotificationProvider>
      <PortalExample />
    </NotificationProvider>
  );
}

export default App;

```

### 19. What is server-side rendering (SSR) in React, and why is it used?

SSR renders React components on the server and sends the fully rendered HTML to the client. This improves initial page load time and SEO.

**Benefits of SSR:**

-   **Better SEO**: Search engines can crawl the content
-   **Faster Initial Load**: Users see content immediately
-   **Better Performance on Slow Devices**: Less JavaScript execution required initially
-   **Social Media Sharing**: Meta tags are available immediately

```jsx
// Next.js SSR Example (pages/users/[id].js)
import React from 'react';
import Head from 'next/head';

// This runs on the server for each request
export async function getServerSideProps(context) {
  const { id } = context.params;
  
  try {
    const response = await fetch(`https://api.example.com/users/${id}`);
    const user = await response.json();
    
    return {
      props: {
        user,
        timestamp: new Date().toISOString()
      }
    };
  } catch (error) {
    return {
      notFound: true
    };
  }
}

function UserProfile({ user, timestamp }) {
  return (
    <>
      <Head>
        <title>{user.name} - User Profile</title>
        <meta name="description" content={`Profile page for ${user.name}`} />
        <meta property="og:title" content={`${user.name} - User Profile`} />
        <meta property="og:description" content={user.bio} />
        <meta property="og:image" content={user.avatar} />
      </Head>
      
      <div>
        <h1>{user.name}</h1>
        <img src={user.avatar} alt={user.name} width="200" />
        <p>{user.bio}</p>
        <p>Email: {user.email}</p>
        <p>Joined: {new Date(user.joinDate).toLocaleDateString()}</p>
        <p>Page rendered at: {timestamp}</p>
      </div>
    </>
  );
}

export default UserProfile;

// Static Site Generation (SSG) Example
export async function getStaticProps() {
  const response = await fetch('https://api.example.com/posts');
  const posts = await response.json();

  return {
    props: {
      posts
    },
    revalidate: 60 // Regenerate page every 60 seconds
  };
}

export async function getStaticPaths() {
  const response = await fetch('https://api.example.com/posts');
  const posts = await response.json();

  const paths = posts.map(post => ({
    params: { id: post.id.toString() }
  }));

  return {
    paths,
    fallback: 'blocking' // Generate pages on-demand
  };
}

function BlogPost({ post }) {
  return (
    <article>
      <h1>{post.title}</h1>
      <p>{post.content}</p>
      <time>{post.publishDate}</time>
    </article>
  );
}

// Custom SSR setup with Express (without Next.js)
const express = require('express');
const React = require('react');
const ReactDOMServer = require('react-dom/server');

const app = express();

app.get('/users/:id', async (req, res) => {
  try {
    const userId = req.params.id;
    const userData = await fetchUser(userId);
    
    const html = ReactDOMServer.renderToString(
      React.createElement(UserProfile, { user: userData })
    );
    
    const fullHtml = `
      <!DOCTYPE html>
      <html>
        <head>
          <title>${userData.name} - User Profile</title>
          <meta name="description" content="Profile page for ${userData.name}" />
        </head>
        <body>
          <div id="root">${html}</div>
          <script>
            window.__INITIAL_DATA__ = ${JSON.stringify(userData)};
          </script>
          <script src="/bundle.js"></script>
        </body>
      </html>

```
