# ws-close-handling

Problem: 

If I manually call `.close`, no close callback gets called. 

To repro: 

```bash 
# setup 
lein repl 
(-main)

# install websocat, or use postman
brew install websocat 

# connect
websocat ws://localhost:8484/ws 
```

