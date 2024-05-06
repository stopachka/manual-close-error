# ws-close-handling

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
;; [1] online! 
# ctrl +c to trigger close, and see it shows up 
;; [1] closed! 
# connect again 
websocat ws://localhost:8484/ws 
# send break 
break 
;; [1] about to break! 
# no close callback called! 
```

