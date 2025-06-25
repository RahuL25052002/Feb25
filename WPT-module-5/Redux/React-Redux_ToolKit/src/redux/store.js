import { configureStore } from '@reduxjs/toolkit'
import counterReducer from '../features/counter/counterslice.js'

export const store = configureStore({
  reducer: {
    counter: counterReducer
  },
})