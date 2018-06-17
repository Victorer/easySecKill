local key = KEYS[1]
local a = ARGV[1]

local count = tonumber(redis.call('get', key.."-count") or "0")
local sale = tonumber(redis.call('get', key.."-sale") or "0")
if count > sale then 
    redis.call("INCRBY", key.."-count", 1)
    redis.call("INCRBY", key.."-sale", 1)
    return 1;
else
    return 0;
end    
