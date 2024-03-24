#!/bin/bash
npm i &
npm run start &
npm run node_1 &
npm run node_2 &
npm run node_3 &
npm run node_4 &
npm run node_5 &
echo "Running nodes 1 - 5"

### Notes:
#### to find/end processes: ps aux | grep "node_1" 
### Shortcut [beware]
"""
kill $(ps aux | grep '[n]ode' | awk '{print $2}')
"""

