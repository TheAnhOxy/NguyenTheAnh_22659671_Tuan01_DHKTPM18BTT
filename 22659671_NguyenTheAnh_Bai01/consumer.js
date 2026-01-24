const amqp = require('amqplib');

async function receiveMessage() {
    try {
        const connection = await amqp.connect('amqp://localhost');
        const channel = await connection.createChannel();

        const queue = 'test_queue';

        await channel.assertQueue(queue, { durable: false });
        console.log(" [*] Dang doi tin nhan trong %s", queue);

        channel.consume(queue, (msg) => {
            console.log(" [x] Da tieu thu: '%s'", msg.content.toString());
        }, { noAck: true });
        
    } catch (error) {
        console.error(error);
    }
}

receiveMessage();