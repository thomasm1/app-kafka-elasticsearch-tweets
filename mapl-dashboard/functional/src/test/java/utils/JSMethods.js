function js() {
    return {
        randomString: function (length) {
            var result = '';
            var characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
            for (var i = 0; i < length; i++) {
                result += characters.charAt(~~(Math.random() * characters.length));
            }
            return result;
        },
        randomInt: function (max) {
            return ~~Math.round(Math.floor(Math.random() * max));
        }
    }
}