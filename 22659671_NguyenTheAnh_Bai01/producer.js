const amqp = require('amqplib');

async function sendMessage() {
    try {
        // Kết nối tới Docker RabbitMQ
        const connection = await amqp.connect('amqp://localhost');
        const channel = await connection.createChannel();

        const queue = 'test_queue';
        const msg = 'Hello MQ';

        await channel.assertQueue(queue, { durable: false });
        channel.sendToQueue(queue, Buffer.from(msg));

        console.log(" [x] Da gui: '%s'", msg);

        setTimeout(() => {
            connection.close();
            process.exit(0);
        }, 500);
    } catch (error) {
        console.error(error);
    }
}

sendMessage();