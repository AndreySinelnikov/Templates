   
var query = {};
pm.request.url.query.all().forEach((param) => { query[param.key] = param.value});

// Retrieve request parameter values with 'query["key"]'
